package com.academia.dashboard;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import com.academia.App;
import com.academia.model.db.DBConnector;
import com.academia.model.service.FinanceiroService;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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

    @FXML
    private AreaChart<?, ?> graficoFaturamento;

    @FXML
    private CategoryAxis X;

    @FXML
    private NumberAxis Y;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FinanceiroService.caculaDebitos();
        FinanceiroService.calculaFaturamento();
        try {
            FinanceiroService.calculaReceita();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (FinanceiroService.getReceita() < 0) {
            receitaPane.setStyle("-fx-background-color: #9C254D");
        }
        else {
            receitaPane.setStyle("-fx-background-color: #ADE792");
        }
        pagamentoTXT.setText(String.valueOf(FinanceiroService.getPagamentos()));
        faturamentoTXT.setText(String.valueOf(FinanceiroService.getFaturamento()));
        receitaTXT.setText(String.valueOf(FinanceiroService.getReceita()));

        XYChart.Series series = new XYChart.Series();
        try(Connection connection = DBConnector.getConexao()) {
            String sql = "SELECT * FROM receita GROUP BY data";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                
                Date date = rs.getDate("data");
                SimpleDateFormat formatter = new SimpleDateFormat("MMMM");
                String mes = formatter.format(date);
                series.getData().add(new XYChart.Data<>(mes, rs.getInt("valor")));
                series.setName("Receita p/Mês");
            }
  
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        graficoFaturamento.getData().addAll(series);
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
