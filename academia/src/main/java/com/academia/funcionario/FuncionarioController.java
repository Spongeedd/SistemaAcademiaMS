package com.academia.funcionario;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.academia.App;
import com.academia.model.dao.FuncionariosDAO;
import com.academia.model.db.DBConnector;
import com.academia.model.dto.FuncionariosDTO;
import com.academia.model.service.FuncionariosService;

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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class FuncionarioController implements Initializable {

    // Inputs

    @FXML
    private TextField cpfID;

    @FXML
    private DatePicker dataID;

    @FXML
    private TextField emailID;

    @FXML
    private TextField enderecoID;

    @FXML
    private TextField horaID;

    @FXML
    private TextField jornadaID;

    @FXML
    private TextField nomeID;

    @FXML
    private TextField buscarInput;

    @FXML
    private TextField telefoneID;


    // Botões

    @FXML
    private Button adicionarBTN;

    @FXML
    private Button atualizarBTN;

    @FXML
    private Button buscarBTN;

    @FXML
    private Button inicioBTN;

    // Tabela

    @FXML
    private TableView<FuncionariosDTO> tabela;

    @FXML
    private TableColumn<FuncionariosDTO, String> tabelaCPF;

    @FXML
    private TableColumn<FuncionariosDTO, String> tabelaData;

    @FXML
    private TableColumn<FuncionariosDTO, String> tabelaEmail;

    @FXML
    private TableColumn<FuncionariosDTO, String> tabelaEndereco;

    @FXML
    private TableColumn<FuncionariosDTO, String> tabelaHora;

    @FXML
    private TableColumn<FuncionariosDTO, String> tabelaJornada;

    @FXML
    private TableColumn<FuncionariosDTO, String> tabelaNome;

    @FXML
    private TableColumn<FuncionariosDTO, Integer> tabelaID;

    @FXML
    private TableColumn<FuncionariosDTO, String> tabelaTelefone;

    @FXML
    private TableColumn<FuncionariosDTO, Integer> tabelaSalario;

    ObservableList<FuncionariosDTO> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            carregarTabela();
            
            FilteredList<FuncionariosDTO> listaAux = new FilteredList<>(oblist, e -> true);
            
            buscarInput.textProperty().addListener((observable, oldvalue, newValue) -> {
                listaAux.setPredicate(FuncionariosDTO -> {
    
                    if (newValue.isEmpty() || newValue.isBlank() || newValue == null) {
                        return true;
                    }
                    String procuraString = newValue.toLowerCase();
    
                    if (FuncionariosDTO.getNome().toLowerCase().indexOf(procuraString) > -1) {
                        return true;
                    }
                    else if (FuncionariosDTO.getCpf().toLowerCase().indexOf(procuraString) > -1) {
                        return true;
                    }
                    else if (FuncionariosDTO.getEmail().toLowerCase().indexOf(procuraString) > -1) {
                        return true;
                    }
                    else {
                        return false;
                    }
                });
            });
            
            SortedList<FuncionariosDTO> listaFiltrada = new SortedList<>(listaAux);
            listaFiltrada.comparatorProperty().bind(tabela.comparatorProperty());
            tabela.setItems(listaFiltrada);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    Alert a = new Alert(AlertType.NONE);
    @FXML
    private void adicionarBTN() throws IOException, SQLException, ClassNotFoundException  {
        String nome = nomeID.getText();
        String telefone = telefoneID.getText();
        String endereco = enderecoID.getText();
        String email = emailID.getText();
        String cpf = cpfID.getText();
        LocalDate dataaux = dataID.getValue();
        Date data = Date.valueOf(dataaux);
        String jornadaaux = jornadaID.getText();
        String phoraaux = horaID.getText();

        
        if (nome.isEmpty() || telefone.isEmpty() || endereco.isEmpty() || email.isEmpty() || jornadaaux.isEmpty() || phoraaux.isEmpty() || cpf.isEmpty()) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("Nenhum campo pode estar vazio");
            a.show();
        }
        else if (FuncionariosDAO.consultaPorCPF(cpf) != null) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("Funcionario ja cadastrado");
            a.show();
        }
        else {
            Integer jornada = Integer.parseInt(jornadaaux);
            Integer phora = Integer.parseInt(phoraaux);
            FuncionariosService.adicionarFuncionario(nome, cpf, data, endereco, telefone, email, jornada, phora);
            carregarTabela();
            limpaInputs();
        }
    }

    @FXML
    private void removerBTN() throws IOException {
        try {
            FuncionariosService.removerFuncionario(getRow());
            carregarTabela();
        } catch (Exception e) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("Nenhum funcionário selecionado");
            a.show();
        }
    }

    @FXML
    private void atualizarBTN() throws IOException {
        try {
            String nome = nomeID.getText();
            String telefone = telefoneID.getText();
            String endereco = enderecoID.getText();
            String email = emailID.getText();
            String cpf = cpfID.getText();
            LocalDate dataaux = dataID.getValue();
            Date data = Date.valueOf(dataaux);
            String jornadaaux = jornadaID.getText();
            String phoraaux = horaID.getText();
            Integer jornada = Integer.parseInt(jornadaaux);
            Integer phora = Integer.parseInt(phoraaux);
            
            if (nome.isEmpty() || telefone.isEmpty() || endereco.isEmpty() || email.isEmpty() || jornadaaux.isEmpty() || phoraaux.isEmpty() || cpf.isEmpty()) {
                a.setAlertType(AlertType.WARNING);
                a.setContentText("Nenhum campo pode estar vazio");
                a.show();
            }
            else if (FuncionariosDAO.consultaPorCPF(cpf) != null) {
                a.setAlertType(AlertType.WARNING);
                a.setContentText("Funcionario ja cadastrado");
                a.show();
            }
            else {
                FuncionariosService.editarFuncionario(getRow(), nome, cpf, data, endereco, telefone, email, jornada, phora);
                carregarTabela();
                limpaInputs();
            }
        } catch (Exception e) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("Nenhum funcionário selecionado");
            a.show();
        }
    }

    public void carregarTabela() throws SQLException, ClassNotFoundException {

        oblist.clear();
        
        tabelaID.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tabelaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tabelaCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tabelaData.setCellValueFactory(new PropertyValueFactory<>("datanascimento"));
        tabelaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        tabelaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tabelaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tabelaJornada.setCellValueFactory(new PropertyValueFactory<>("jornada"));
        tabelaHora.setCellValueFactory(new PropertyValueFactory<>("phora"));
        tabelaSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        
        try(Connection connection = DBConnector.getConexao()) {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM funcionario");
            while (rs.next()) {
                oblist.add(new FuncionariosDTO(rs.getInt("idfuncionario"), rs.getString("nome"),
                            rs.getString("cpf"), rs.getDate("nascimento"), rs.getString("endereco"), rs.getString("telefone"),
                            rs.getString("email"), rs.getInt("jornada"), rs.getInt("phora"), rs.getInt("salario")));
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
        dataID.setValue(null);
        jornadaID.setText("");
        horaID.setText("");
        cpfID.setText("");
    }
    Integer codigo;
    public Integer getRow() {
        FuncionariosDTO dto = tabela.getSelectionModel().getSelectedItem();
        return codigo = dto.getCodigo();
    }
    
    @FXML
    private void voltarBTN() throws IOException {
        Stage stage = new Stage();
            Parent root = FXMLLoader.load(App.class.getResource("InterfaceLogin.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Cadastrar Funcionario");
            stage.setResizable(false);
            stage.getIcons().add(new Image(App.class.getResourceAsStream("icone.png")));
            stage.show();
            stage = (Stage) inicioBTN.getScene().getWindow();
            stage.close();
    }

}