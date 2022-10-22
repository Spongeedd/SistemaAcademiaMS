package com.academia;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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

        if (login.equals("admin") && senha.equals("123")) {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(App.class.getResource("InterfaceCadastrarFuncionario.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Cadastrar Funcionario");
            stage.setResizable(false);
            stage.getIcons().add(new Image(App.class.getResourceAsStream("icone.png")));
            stage.show();
            stage = (Stage) btnEntrar.getScene().getWindow();
            stage.close();
        }
        else {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(App.class.getResource("InterfaceMatricula.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Cadastrar Matrícula");
            stage.setResizable(false);
            stage.getIcons().add(new Image(App.class.getResourceAsStream("icone.png")));
            stage.show();
            stage = (Stage) btnEntrar.getScene().getWindow();
            stage.close();
        }
    }

}