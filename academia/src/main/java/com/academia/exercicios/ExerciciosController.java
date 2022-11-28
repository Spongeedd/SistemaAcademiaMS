package com.academia.exercicios;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.academia.App;
import com.academia.model.db.DBConnector;
import com.academia.model.dto.ExerciciosDTO;
import com.academia.model.service.ExerciciosService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ExerciciosController implements Initializable {
    @FXML
    private ChoiceBox<String> BuscarID;

    @FXML
    private MenuItem MenuID;

    @FXML
    private MenuItem matriculaBTN;

    @FXML
    private TextArea descricaoID;

    @FXML
    private MenuItem FuncionariosBTN;

    @FXML
    private ChoiceBox<String> planoID;

    @FXML
    private TextField repeticoesID;

    @FXML
    private TextField serieID;

    @FXML
    private TableView<ExerciciosDTO> tabela;

    @FXML
    private TableColumn<ExerciciosDTO, String> tabelaDescricao;

    @FXML
    private TableColumn<ExerciciosDTO, Integer> tabelaID;

    @FXML
    private TableColumn<ExerciciosDTO, String> tabelaPlano;

    @FXML
    private Button addBTN;

    @FXML
    private Button rmvBTN;

    @FXML
    private Button buscarBTN;

    @FXML
    private Label descTXT;
    
    @FXML
    private Label idTXT;

    @FXML
    private Label planoTXT;

    @FXML
    private Label repTXT;

    @FXML
    private Label serieTXT;


    private String[] planoStrings = {"Basico", "Intermediário", "Premium"};
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            carregarTabela();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        planoID.setValue("Basico");
        planoID.getItems().addAll(planoStrings);
    }

    Alert a = new Alert(AlertType.NONE);
    @FXML
    private void addBTN() throws IOException, ClassNotFoundException, SQLException {
        String descricao = descricaoID.getText();
        String serie = serieID.getText();
        String repeticoes = repeticoesID.getText();
        String plano = planoID.getValue();

        if (descricao.isEmpty() || serie.isEmpty() || repeticoes.isEmpty()) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("Nenhum campo pode estar vazio");
            a.show();
        }

        else {
            ExerciciosService.adicionarExercicios(plano, descricao, serie, repeticoes);
            carregarTabela();
            limpaInputs();
        }
    }

    @FXML
    private void removerBTN() throws IOException {
        try {
            ExerciciosService.removerExercicio(getRow());
            carregarTabela();
        } catch (Exception e) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("Nenhum exercício selecionado");
            a.show();
        }
    }

    @FXML
    private void buscarBTN() throws IOException {
        Integer cdg = getRow();
       
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "SELECT * FROM exercicios WHERE idexercicios = "+ cdg +"";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                idTXT.setText(String.valueOf(rs.getInt("idexercicios")));
                planoTXT.setText(rs.getString("plano"));
                descTXT.setText(rs.getString("descricao"));
                serieTXT.setText(rs.getString("serie"));
                repTXT.setText(rs.getString("repeticoes"));
            }
            else {
                a.setAlertType(AlertType.WARNING);
                a.setContentText("Nenhum exercício selecionado");
                a.show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        
    }

    Integer codigo;
    public Integer getRow() {
        ExerciciosDTO dto = tabela.getSelectionModel().getSelectedItem();
        return codigo = dto.getId();
    }

    ObservableList<ExerciciosDTO> oblist = FXCollections.observableArrayList();
    private void carregarTabela() throws ClassNotFoundException {

        oblist.clear();

        tabelaID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabelaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tabelaPlano.setCellValueFactory(new PropertyValueFactory<>("plano"));
        
        try(Connection connection = DBConnector.getConexao()) {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM exercicios");
            while (rs.next()) {
                oblist.add(new ExerciciosDTO(rs.getInt("idexercicios"), rs.getString("descricao"), rs.getString("plano")));
            }
            tabela.setItems(oblist);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private void limpaInputs() {
        descricaoID.setText("");
        serieID.setText("");
        repeticoesID.setText("");
    }
   
    @FXML
    private void matriculaBTN() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(App.class.getResource("InterfaceMatricula.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Matricula");
        stage.setResizable(false);
        stage.getIcons().add(new Image(App.class.getResourceAsStream("icone.png")));
        stage.show();
        stage = (Stage) addBTN.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void FuncionariosBTN() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(App.class.getResource("InterfaceCadastrarFuncionario.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Cadastrar Funcionario");
        stage.setResizable(false);
        stage.getIcons().add(new Image(App.class.getResourceAsStream("icone.png")));
        stage.show();
        stage = (Stage) addBTN.getScene().getWindow();
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
        stage = (Stage) addBTN.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void atribuirExercicios() throws IOException {
        String matricula = idMatricula.getText();
        String exercicio = idExercicio.getText();
        
        ExerciciosService.atribuirExercicio (idExercicio, idMatricula);
    }
    
    @FXML
    private void desatribuirExercicios() throws IOException {
        String ficha = idFicha.getText();
        
        ExerciciosService.desatribuirExercicios (idFicha);
    }
    
    ObservableList<ExerciciosDTO> listaMatriculas = FXCollections.observableArrayList();
    private void carregaMatricula() throws ClassNotFoundException {

        listaMatriculas.clear();

        tabelaID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabelaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tabelaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tabelaPlano.setCellValueFactory(new PropertyValueFactory<>("plano"));
        tabelaFicha.setCellValueFactory(new PropertyValueFactory<>("ficha"));
        
        
        try(Connection connection = DBConnector.getConexao()) {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM exercicios");
            while (rs.next()) {
                listaMatriculas.add(new ExerciciosDTO(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("plano"), rs.getInt("ficha")));
            }
            tabela.setItems(listaMatriculas);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
