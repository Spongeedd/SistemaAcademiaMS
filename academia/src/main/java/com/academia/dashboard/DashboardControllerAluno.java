package com.academia.dashboard;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.academia.App;
import com.academia.model.db.DBConnector;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DashboardControllerAluno implements Initializable {
    @FXML
    private BorderPane bordepane;

    @FXML
    private Label idtxt;

    @FXML
    private Label pacotetxt;

    @FXML
    private Label planotxt;

    @FXML
    private Label descTXT;

    @FXML
    private AnchorPane inicio;

    @FXML
    private AnchorPane panel;

    @FXML
    private Label repTXT;

    @FXML
    private Label serieTXT;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    @FXML
    void menuAluno(MouseEvent event) {
        bordepane.setCenter(panel);
    }

    @FXML
    void menuContas(MouseEvent event) {
        loadPage("InterfaceBoleto");
    }
    public void mostraAluno (Integer id) {
        idtxt.setText(String.valueOf(id));
        Integer idexecicio = null;
        try (Connection connection = DBConnector.getConexao()) {
            String sql = "SELECT * FROM  matricula WHERE idmatricula = "+ id +"";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
               planotxt.setText(rs.getString("plano"));
               pacotetxt.setText(rs.getString("pacote"));
               idexecicio = rs.getInt("ficha");
            }

            sql = "SELECT * FROM exercicios WHERE idexercicios = "+ idexecicio +"";
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                descTXT.setText(rs.getString("descricao"));
                serieTXT.setText(rs.getString("serie"));
                repTXT.setText(rs.getString("repeticoes"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void signOut(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(App.class.getResource("InterfaceLogin.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Login");
        stage.setResizable(false);
        stage.getIcons().add(new Image(App.class.getResourceAsStream("icone.png")));
        stage.show();
        stage = (Stage) bordepane.getScene().getWindow();
        stage.close();
    }

    private void loadPage(String page) {
        Parent root = null;
        try {
            root = FXMLLoader.load(App.class.getResource(page+".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        bordepane.setCenter(root);
    }


}
