package com.academia.funcionario;

import java.io.IOException;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;


public class FuncionarioController {

    @FXML
    private Button adicionarBTN;

    @FXML
    private Button atualizaarBTN;

    @FXML
    private TextField cpfID;

    @FXML
    private DatePicker dataID;

    @FXML
    private TextField emailID;

    @FXML
    private TextField enderecoID;

    @FXML
    private TextField horaID;

    @FXML
    private TextField jornadaID;

    @FXML
    private TextField nomeID;

    @FXML
    private Button removerBTN;

    @FXML
    private TextField telefoneID;

    Alert a;
    @FXML
    private void cadastrarBTN() throws IOException {
        
        try {
            String nome = nomeID.getText();
            String numero = telefoneID.getText();
            String endereco = enderecoID.getText();
            String email = emailID.getText();
            LocalDate data = dataID.getValue();
            String jornada = jornadaID.getText();
            String phora = horaID.getText();
            String cpf = cpfID.getText();

            Long telefone = Long.parseLong(numero);
            
            if (nome.isEmpty() || telefone==null) {
                a.setAlertType(AlertType.WARNING);
                a.setContentText("Campos Nome/Número não podem estar vazio");
                a.show();
            }
            else if (FuncionariosDAO.consultaPorNome(nome) != null) {
                a.setAlertType(AlertType.WARNING);
                a.setContentText("Contato ja cadastrado");
                a.show();
            }
            else {
                Service.adicionarContato(nome, endereco, email, cpf, telefone, data, jornada, phora);
                carregarTabela();
                limpaInputs();
            }
        } catch (Exception e) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("Número não pode conter letras");
            a.show();
        }
    }


    public void carregarTabela() {
        .setCellValueFactory(new PropertyValueFactory<>("codigo"));
        .setCellValueFactory(new PropertyValueFactory<>("nome"));
        .setCellValueFactory(new PropertyValueFactory<>("telefone"));
        .setCellValueFactory(new PropertyValueFactory<>("tipo"));
        .setCellValueFactory(new PropertyValueFactory<>("email"));
        .setCellValueFactory(new PropertyValueFactory<>("rua"));
        .setCellValueFactory(new PropertyValueFactory<>("bairro"));
        .setCellValueFactory(new PropertyValueFactory<>("grupo"));

        contatosTabela.setItems(FuncionariosDAO.getObservableListClientes());
    }
}


