package com.academia.matricula;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.academia.App;
import com.academia.model.dao.MatriculaDAO;
import com.academia.model.db.DBConnector;
import com.academia.model.dto.MatriculaDTO;
import com.academia.model.service.MatriculaService;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MatriculaController implements Initializable{

    // INPUTS

    @FXML
    private TextField nomeID;

    @FXML
    private TextField cpfID;

    @FXML
    private DatePicker nascimentoID;

    @FXML
    private TextField enderecoID;

    @FXML
    private TextField emailID;

    @FXML
    private ChoiceBox<String> pacoteID;

    @FXML
    private ChoiceBox<String> planoID;

    @FXML
    private TextField telefoneID;


    @FXML
    private TextField buscarInput;

    // TABELA

    @FXML
    private TableView<MatriculaDTO> tabela;

    @FXML
    private TableColumn<MatriculaDTO, Integer> tabelaID;

    @FXML
    private TableColumn<MatriculaDTO, String> tabelaTelefone;

    @FXML
    private TableColumn<MatriculaDTO, String> tabelaEmail;

    @FXML
    private TableColumn<MatriculaDTO, String> tabelaNascimento;

    @FXML
    private TableColumn<MatriculaDTO, String> tabelaNome;

    @FXML
    private TableColumn<MatriculaDTO, String> tabelaCPF;

    @FXML
    private TableColumn<MatriculaDTO, String> tabelaPacote;

    @FXML
    private TableColumn<MatriculaDTO, String> tabelaEndereco;

    @FXML
    private TableColumn<MatriculaDTO, String> tabelaPlano;

    // BOTÕES

    @FXML
    private MenuItem catracaBTN;

    @FXML
    private MenuItem exerciciosBTN;
    
    @FXML
    private Button removerBTN;

    @FXML
    private Button adicionarBTN;

    @FXML
    private Button atualizarBTN;

    @FXML
    private Button inicioBTN;



    private String[] pacoteStrings = {"Mensal", "Trimestral", "Anual"};
    private String[] planoStrings = {"Basico", "Intermediário", "Premium"};
    ObservableList<MatriculaDTO> oblist = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            pacoteID.setValue("Mensal");
            pacoteID.getItems().addAll(pacoteStrings);
            planoID.setValue("Basico");
            planoID.getItems().addAll(planoStrings);
            carregarTabela();
            
            FilteredList<MatriculaDTO> listaAux = new FilteredList<>(oblist, e -> true);
            
            buscarInput.textProperty().addListener((observable, oldvalue, newValue) -> {
                listaAux.setPredicate(MatriculaDTO -> {
                    
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }
                    String procuraString = newValue.toLowerCase();
                    
                    if (MatriculaDTO.getNome().toLowerCase().indexOf(procuraString) > -1) {
                        return true;
                    }
                    else if (MatriculaDTO.getCpf().toLowerCase().indexOf(procuraString) > -1) {
                        return true;
                    }
                    else if (MatriculaDTO.getEmail().toLowerCase().indexOf(procuraString) > -1) {
                        return true;
                    }
                    else {
                        return false;
                    }
                });
            });
            
            SortedList<MatriculaDTO> listaFiltrada = new SortedList<>(listaAux);
            listaFiltrada.comparatorProperty().bind(tabela.comparatorProperty());
            tabela.setItems(listaFiltrada);
        } catch (SQLException ex) {
            Logger.getLogger(MatriculaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MatriculaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Alert a = new Alert(AlertType.NONE);
    @FXML
    private void adicionarBTN() throws IOException  {
        try {
            String pacote = pacoteID.getValue();
            String plano = planoID.getValue();

            String nome = nomeID.getText();
            String telefone = telefoneID.getText();
            String endereco = enderecoID.getText();
            String email = emailID.getText();
            String cpf = cpfID.getText();
            LocalDate dataaux = nascimentoID.getValue();
            Date data = Date.valueOf(dataaux);

            if (nome.isEmpty() || telefone.isEmpty() || endereco.isEmpty() || email.isEmpty() || cpf.isEmpty()) {
                a.setAlertType(AlertType.WARNING);
                a.setContentText("Nenhum campo pode estar vazio");
                a.show();
            }
            else if (MatriculaDAO.consultaPorCPF(cpf) != null) {
                a.setAlertType(AlertType.WARNING);
                a.setContentText("Aluno ja cadastrado");
                a.show();
            }
            else {
                MatriculaService.adicionarMatricula(nome, cpf, data, endereco, telefone, email, plano, pacote);
                carregarTabela();
                limpaInputs();
            }
        } catch (Exception e) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("Telefone/CPF/ não podem conter letras");
            a.show();
        }
    }

    @FXML
    private void removerBTN() throws IOException {
        try {
            MatriculaService.removerMatricula(getRow());
            carregarTabela();
        } catch (Exception e) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("Nenhuma matrícula selecionada");
            a.show();
        }
    }

    @FXML
    private void atualizarBTN() throws IOException {
        try {
            String pacote = pacoteID.getValue();
            String plano = planoID.getValue();

            String nome = nomeID.getText();
            String telefone = telefoneID.getText();
            String endereco = enderecoID.getText();
            String email = emailID.getText();
            String cpf = cpfID.getText();
            LocalDate dataaux = nascimentoID.getValue();
            Date data = Date.valueOf(dataaux);

            if (nome.isEmpty() || telefone.isEmpty() || endereco.isEmpty() || email.isEmpty() || cpf.isEmpty()) {
                a.setAlertType(AlertType.WARNING);
                a.setContentText("Nenhum campo pode estar vazio");
                a.show();
            }
            else if (MatriculaDAO.consultaPorCPF(cpf) != null) {
                a.setAlertType(AlertType.WARNING);
                a.setContentText("Aluno ja cadastrado");
                a.show();
            }
            else {

                MatriculaService.editarMatricula(getRow(),nome, cpf, data, endereco, telefone, email, plano, pacote);

                MatriculaService.editarMatricula(getRow(), nome, cpf, data, endereco, telefone, email, plano, pacote);

                carregarTabela();
                limpaInputs();
            }
        } catch (Exception e) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("Telefone/CPF/ não podem conter letras");
            a.show();
        }
    }

    
    public void carregarTabela() throws SQLException, ClassNotFoundException {

        oblist.clear();

        tabelaID.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tabelaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tabelaCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tabelaNascimento.setCellValueFactory(new PropertyValueFactory<>("datanascimento"));
        tabelaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        tabelaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tabelaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tabelaPlano.setCellValueFactory(new PropertyValueFactory<>("plano"));
        tabelaPacote.setCellValueFactory(new PropertyValueFactory<>("pacote"));

        try(Connection connection = DBConnector.getConexao()) {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM matricula");
            while (rs.next()) {
                oblist.add(new MatriculaDTO(rs.getInt("idmatricula"), rs.getString("nome"),
                            rs.getString("cpf"), rs.getDate("nascimento"), rs.getString("endereco"), rs.getString("telefone"),
                            rs.getString("email"), rs.getString("plano"), rs.getString("pacote")));
            }
            tabela.setItems(oblist);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void limpaInputs(){
        nomeID.setText("");
        telefoneID.setText("");
        enderecoID.setText("");
        emailID.setText("");
        nascimentoID.setValue(null);
        cpfID.setText("");
    }
    Integer codigo;
    public Integer getRow() {
        MatriculaDTO dto = tabela.getSelectionModel().getSelectedItem();
        return codigo = dto.getCodigo();
    }

    @FXML
    private void catracaBTN() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(App.class.getResource("CatracaBase.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Catraca");
        stage.setResizable(false);
        stage.getIcons().add(new Image(App.class.getResourceAsStream("icone.png")));
        stage.show();
        stage = (Stage) inicioBTN.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void exerciciosBTN() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(App.class.getResource("CatracaBase.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Exercicios");
        stage.setResizable(false);
        stage.getIcons().add(new Image(App.class.getResourceAsStream("icone.png")));
        stage.show();
        stage = (Stage) inicioBTN.getScene().getWindow();
        stage.close();
    }


    @FXML
    private void voltarBTN() throws IOException {
        Stage stage = new Stage();
            Parent root = FXMLLoader.load(App.class.getResource("InterfaceLogin.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Login");
        stage.setResizable(false);
        stage.getIcons().add(new Image(App.class.getResourceAsStream("icone.png")));
        stage.show();
        stage = (Stage) inicioBTN.getScene().getWindow();
        stage.close();
    }
}