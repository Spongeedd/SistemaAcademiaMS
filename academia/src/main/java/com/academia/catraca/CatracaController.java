package com.academia.catraca;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.academia.App;
import com.academia.model.dao.CatracaDAO;
import com.academia.model.db.DBConnector;
import com.academia.model.dto.CatracaDTO;
import com.academia.model.service.CatracaService;

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
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CatracaController implements Initializable {
    @FXML
    private Button botaoEntrar;

    @FXML
    private MenuItem inicioID;
    
    @FXML
    private TextField loginID;

    @FXML
    private ImageView perfilFoto;

    @FXML
    private TextField senhaID;

    @FXML
    private TableView<CatracaDTO> tabela;

    @FXML
    private TableColumn<CatracaDTO, String> tabelaAluno;

    @FXML
    private TableColumn<CatracaDTO, Integer> tabelaCodigo;

    @FXML
    private TableColumn<CatracaDTO, String> tabelaData;

    @FXML
    private Label acessoID;

    @FXML
    private Label alunoNome;

    @FXML
    private Label planoID;

    
    Alert a = new Alert(AlertType.NONE);
    @FXML
    private void entrarBTN() throws IOException, ClassNotFoundException, SQLException {
        String login = loginID.getText();
        String senha = senhaID.getText();

        if (login.isEmpty() || senha.isEmpty()) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("Nenhum campo pode estar vazio");
            a.show();
        }
        else if (CatracaService.login(login, senha) == null) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("Login não encontrado");
            a.show();
        }
        else {
            Integer id = CatracaService.login(login, senha);
            CatracaService.adicionaCatraca(id);
            carregarTabela();
            limpaInputs();
            String acessos = String.valueOf(CatracaDAO.getAcessos());
            acessoID.setText(acessos);
            alunoNome.setText(CatracaService.getNome(id));
            planoID.setText(CatracaService.getPlano(id));
        }
    }

    public void limpaInputs(){
        loginID.setText("");
        senhaID.setText("");
    }
    
    ObservableList<CatracaDTO> oblist = FXCollections.observableArrayList();
    public void carregarTabela() throws SQLException, ClassNotFoundException {

        oblist.clear();
        
        tabelaCodigo.setCellValueFactory(new PropertyValueFactory<>("ID"));
        tabelaAluno.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tabelaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        
        try(Connection connection = DBConnector.getConexao()) {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM acessoaluno");
            while (rs.next()) {
                oblist.add(new CatracaDTO(rs.getInt("idaluno"), rs.getString("nome"), rs.getTimestamp("data")));
            }
            
            tabela.setItems(oblist);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void inicioID() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(App.class.getResource("InterfaceLogin.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Login");
        stage.setResizable(false);
        stage.getIcons().add(new Image(App.class.getResourceAsStream("icone.png")));
        stage.show();
        stage = (Stage) botaoEntrar.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            carregarTabela();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
