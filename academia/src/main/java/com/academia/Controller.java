package com.academia;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import com.academia.dashboard.DashboardControllerAluno;
import com.academia.model.db.DBConnector;
import com.academia.model.service.CobrancaService;
import com.academia.model.service.LogService;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
    private void exibeInfo() throws IOException, ClassNotFoundException, ParseException {
        try(Connection connection = DBConnector.getConexao()) {
            
            String senha = senhaInput.getText();
            String login = funcionarioInput.getText();
            String sql = "SELECT * FROM funcionario WHERE nome=? and cpf=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, senha);
            ResultSet rs = preparedStatement.executeQuery();
            Alert a = new Alert(AlertType.NONE);
            if (login.equals("admin") && senha.equals("123")) {
                CobrancaService.adicionaCobranca();
                LogService.setUsuario("admin");
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(App.class.getResource("DashboardAdmin.fxml"));
                stage.setScene(new Scene(root));
                stage.setTitle("Sistema Academia");
                stage.setResizable(false);
                stage.getIcons().add(new Image(App.class.getResourceAsStream("icone.png")));
                stage.show();
                stage = (Stage) btnEntrar.getScene().getWindow();
                stage.close();
            }
            else if (rs.next()) {
                LogService.setUsuario(rs.getString("nome"));
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(App.class.getResource("DashboardFuncionario.fxml"));
                stage.setScene(new Scene(root));
                stage.setTitle("Sistema Academia");
                stage.setResizable(false);
                stage.getIcons().add(new Image(App.class.getResourceAsStream("icone.png")));
                stage.show();
                stage = (Stage) btnEntrar.getScene().getWindow();
                stage.close();
            }
            else {
                sql = "SELECT * FROM matricula WHERE nome=? and cpf=?";
                preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, senha);
                rs = preparedStatement.executeQuery();   
                if (rs.next()) {

                    FXMLLoader loader = new FXMLLoader(App.class.getResource("DashboardAluno.fxml"));
                    Parent root = loader.load();
                    Integer id = rs.getInt("idmatricula");
                    CobrancaService.setUsuario(id);
                    DashboardControllerAluno dashboardControllerAluno = loader.getController();
                    dashboardControllerAluno.mostraAluno(id);

                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Sistema Academia");
                    stage.setResizable(false);
                    stage.getIcons().add(new Image(App.class.getResourceAsStream("icone.png")));
                    stage.show();
                    stage = (Stage) btnEntrar.getScene().getWindow();
                    stage.close();
                }
                else {
                    a.setAlertType(AlertType.WARNING);
                    a.setContentText("Login não encontrado");
                    a.show();
                }             
            }
    } catch (SQLException e) {
            throw new RuntimeException(e);
        }   

    }
}