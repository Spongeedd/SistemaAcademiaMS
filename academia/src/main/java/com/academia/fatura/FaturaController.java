package com.academia.fatura;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.academia.model.dao.CobrancaDAO;
import com.academia.model.db.DBConnector;
import com.academia.model.dto.CobrancaDTO;
import com.academia.model.service.CobrancaService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class FaturaController implements Initializable {
    @FXML
    private Label situacaoLabel;

    @FXML
    private Pane situacaoPane;

    @FXML
    private TableView<CobrancaDTO> tabela;

    @FXML
    private TableColumn<CobrancaDTO, Integer> tblvalor;

    @FXML
    private TableColumn<CobrancaDTO, String> tblvencimento;

    @FXML
    private TableColumn<CobrancaDTO, Integer> tblID;

    @FXML
    private Button pagarBTN;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            carregarTabela();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (CobrancaService.verificaStatus(CobrancaService.getUsuario()) == true) {
            situacaoPane.setStyle("-fx-background-color: #9C254D");
            situacaoLabel.setText("Bloqueado");
        }
        else {
            situacaoPane.setStyle("-fx-background-color: #ADE792");
            situacaoLabel.setText("Liberado");
        }
    }
    Alert a = new Alert(AlertType.NONE);
    @FXML
    private void pagarBTN() throws IOException {
        try {
            CobrancaService.quitarCobranca(getRowBoleto());
            carregarTabela();
        } catch (ClassNotFoundException e) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("Fatura Paga");
            a.show();
        }
    }

    Integer codigoaluno;
    public Integer getRowBoleto() {
        CobrancaDTO dto = tabela.getSelectionModel().getSelectedItem();
        return codigoaluno = dto.getIdboleto();
    }

    ObservableList<CobrancaDTO> oblist = FXCollections.observableArrayList();
    private void carregarTabela() throws ClassNotFoundException {

        oblist.clear();

        tblID.setCellValueFactory(new PropertyValueFactory<>("idboleto"));
        tblvalor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        tblvencimento.setCellValueFactory(new PropertyValueFactory<>("vencimento"));
       
        
        try(Connection connection = DBConnector.getConexao()) {
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM boletos WHERE idaluno = "+ CobrancaDAO.getUsuario() +"");
            while (rs.next()) {
                oblist.add(new CobrancaDTO(rs.getInt("idboletos"), rs.getInt("valor"), rs.getDate("vencimento")));
            }
            tabela.setItems(oblist);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
}
