package com.academia.dashboard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.academia.App;
import com.academia.model.service.FinanceiroService;

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

public class DashboardController implements Initializable {

    @FXML
    private AnchorPane panel;

    @FXML
    private AnchorPane receitaPane;

    @FXML
    private BorderPane bordepane;

    @FXML
    private Label pagamentoTXT;

    @FXML
    private Label faturamentoTXT;

    @FXML
    private Label receitaTXT;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FinanceiroService.caculaDebitos();
        FinanceiroService.calculaFaturamento();
        FinanceiroService.calculaReceita();
        if (FinanceiroService.getReceita() < 0) {
            receitaPane.setStyle("-fx-background-color: #9C254D");
        }
        else {
            receitaPane.setStyle("-fx-background-color: #ADE792");
        }
        pagamentoTXT.setText(String.valueOf(FinanceiroService.getPagamentos()));
        faturamentoTXT.setText(String.valueOf(FinanceiroService.getFaturamento()));
        receitaTXT.setText(String.valueOf(FinanceiroService.getReceita()));
    }

    @FXML
    private void dashboard (MouseEvent event) {
        bordepane.setCenter(panel);
    }
    @FXML
    private void cadastrarFuncionario (MouseEvent event) {
        loadPage("InterfaceCadastrarFuncionario");
    }
    @FXML
    private void cadastrarMatricula (MouseEvent event) {
        loadPage("InterfaceMatricula");
    }
    @FXML
    private void signOut (MouseEvent event) throws IOException {
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
