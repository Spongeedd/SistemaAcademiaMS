package com.academia;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private TextField senhaInput;

    @FXML
    private TextField funcionarioInput;

    @FXML
    private Button btnEntrar;
    
    @FXML
    private void exibeInfo() throws IOException {
        String senha = senhaInput.getText();
        String login = funcionarioInput.getText();

        System.out.println(login + " - " + senha);
        
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(App.class.getResource("InterfaceCadastrar.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Cadastrar");
        stage.setResizable(false);
        stage.show();
        stage = (Stage) btnEntrar.getScene().getWindow();
        stage.close();
    }

}