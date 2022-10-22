package com.academia.funcionario;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;


public class FuncionarioController {

    // Inputs

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
    private TextField telefoneID;

    // Botões

    @FXML
    private Button adicionarBTN;

    @FXML
    private Button atualizaarBTN;

    @FXML
    private Button removerBTN;

    // Tabela

    @FXML
    private TableView<FuncionariosDTO> tabela;

    @FXML
    private TableColumn<FuncionariosDTO, String> tabelaCPF;

    @FXML
    private TableColumn<FuncionariosDTO, String> tabelaData;

    @FXML
    private TableColumn<FuncionariosDTO, String> tabelaEmail;

    @FXML
    private TableColumn<FuncionariosDTO, String> tabelaEndereco;

    @FXML
    private TableColumn<FuncionariosDTO, String> tabelaHora;

    @FXML
    private TableColumn<FuncionariosDTO, String> tabelaJornada;

    @FXML
    private TableColumn<FuncionariosDTO, String> tabelaNome;

    @FXML
    private TableColumn<FuncionariosDTO, Integer> tabelaID;

    @FXML
    private TableColumn<FuncionariosDTO, String> tabelaTelefone;


    Alert a = new Alert(AlertType.NONE);
    @FXML
    private void adicionarBTN() throws IOException {
        
        try {
            String nome = nomeID.getText();
            String numero = telefoneID.getText();
            String endereco = enderecoID.getText();
            String email = emailID.getText();
            LocalDate dataaux = dataID.getValue();
            String jornadaaux = jornadaID.getText();
            String phoraaux = horaID.getText();
            String cpfaux = cpfID.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String data = dataaux.format(formatter);
            System.out.println(data);

            Long telefone = Long.parseLong(numero);
            Long cpf = Long.parseLong(cpfaux);
            Integer jornada = Integer.parseInt(jornadaaux);
            Integer phora = Integer.parseInt(phoraaux);
            
            if (nome.isEmpty() || numero.isEmpty() || endereco.isEmpty() || email.isEmpty() || jornadaaux.isEmpty() || phoraaux.isEmpty() || cpfaux.isEmpty()) {
                a.setAlertType(AlertType.WARNING);
                a.setContentText("Nenhum campo pode estar vazio");
                a.show();
            }
            else if (FuncionariosDAO.consultaPorCPF(cpf) != null) {
                a.setAlertType(AlertType.WARNING);
                a.setContentText("Funcionario ja cadastrado");
                a.show();
            }
            else {
                FuncionariosService.adicionarFuncionario(nome, cpf, data, endereco, telefone, email, jornada, phora);
                carregarTabela();
                limpaInputs();
            }
        } catch (Exception e) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("Telefone/CPF/Jornada/PHora não podem conter letras");
            a.show();
        }
    }

    public void carregarTabela() {
        tabelaID.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tabelaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tabelaCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tabelaData.setCellValueFactory(new PropertyValueFactory<>("datanascismento"));
        tabelaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        tabelaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tabelaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tabelaJornada.setCellValueFactory(new PropertyValueFactory<>("jornada"));
        tabelaHora.setCellValueFactory(new PropertyValueFactory<>("phora"));

        tabela.setItems(FuncionariosDAO.getObservableListFuncionarios());
    }

    public void limpaInputs(){
        nomeID.setText("");
        telefoneID.setText("");
        enderecoID.setText("");
        emailID.setText("");
        dataID.setValue(null);
        jornadaID.setText("");
        horaID.setText("");
        cpfID.setText("");
    }
    Integer codigo;
    public Integer getRow() {
        FuncionariosDTO dto = tabela.getSelectionModel().getSelectedItem();
        return codigo = dto.getCodigo();
    }
}


