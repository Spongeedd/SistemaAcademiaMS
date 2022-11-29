package com.academia.dashboard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.academia.App;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DashboardControllerFunc implements Initializable {
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadPage("InterfaceMatricula");
    }

    @FXML
    private BorderPane bordepane;

    @FXML
    private AnchorPane inicio;

    @FXML
    private AnchorPane panel;

    @FXML
    void cadastrarExercicios(MouseEvent event) {
        loadPage("InterfaceExercícios");
    }

    @FXML
    void cadastrarMatricula(MouseEvent event) {
        loadPage("InterfaceMatricula");
    }

    @FXML
    void catraca(MouseEvent event) {
        loadPage("CatracaBase");
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
