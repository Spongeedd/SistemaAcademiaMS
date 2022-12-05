package com.academia.log;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.academia.model.db.DBConnector;
import com.academia.model.dto.LogDTO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class LogController implements Initializable {

    @FXML
    private TableColumn<LogDTO, String> acaotbl;

    @FXML
    private TableColumn<LogDTO, String> horatbl;

    @FXML
    private TableView<LogDTO> tabela;

    @FXML
    private TableColumn<LogDTO, String> usuariotbl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            carregarTabela();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    ObservableList<LogDTO> oblist = FXCollections.observableArrayList();
    private void carregarTabela() throws ClassNotFoundException {

        oblist.clear();

        usuariotbl.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        acaotbl.setCellValueFactory(new PropertyValueFactory<>("acao"));
        horatbl.setCellValueFactory(new PropertyValueFactory<>("data"));
        
        try(Connection connection = DBConnector.getConexao()) {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM log");
            while (rs.next()) {
                oblist.add(new LogDTO(rs.getString("acao"), rs.getString("usuario"), rs.getTimestamp("hora")));
            }
            tabela.setItems(oblist);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
