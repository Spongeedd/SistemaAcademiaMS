package com.academia.matricula;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class MatriculaController implements Initializable{

    // INPUTS

    @FXML
    private TextField nomeID;

    @FXML
    private TextField cpfID;

    @FXML
    private DatePicker nascimentoID;

    @FXML
    private TextField enderecoID;

    @FXML
    private TextField emailID;

    @FXML
    private ChoiceBox<String> pacoteID;

    @FXML
    private ChoiceBox<String> planoID;

    @FXML
    private TextField telefoneID;

    // TABELA

    @FXML
    private TableView<MatriculaDTO> tabela;

    @FXML
    private TableColumn<MatriculaDTO, Integer> tabelaID;

    @FXML
    private TableColumn<MatriculaDTO, String> tabelaTelefone;

    @FXML
    private TableColumn<MatriculaDTO, String> tabelaEmail;

    @FXML
    private TableColumn<MatriculaDTO, String> tabelaNascimento;

    @FXML
    private TableColumn<MatriculaDTO, String> tabelaNome;

    @FXML
    private TableColumn<MatriculaDTO, String> tabelaCPF;

    @FXML
    private TableColumn<MatriculaDTO, String> tabelaPacote;

    @FXML
    private TableColumn<MatriculaDTO, String> tabelaEndereco;

    @FXML
    private TableColumn<MatriculaDTO, String> tabelaPlano;

    // BOTÕES

    @FXML
    private Button removerBTN;

    @FXML
    private Button adicionarBTN;

    @FXML
    private Button atualizarBTN;


    private String[] pacoteStrings = {"Mensal", "Trimestral", "Anual"};
    private String[] planoStrings = {"Basico", "Intermediário", "Premium"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pacoteID.setValue("Mensal");
        pacoteID.getItems().addAll(pacoteStrings);
        planoID.setValue("Basico");
        planoID.getItems().addAll(planoStrings);
    }

    Alert a = new Alert(AlertType.NONE);
    @FXML
    private void adicionarBTN() throws IOException  {
        try {
            String nome = nomeID.getText();
            String numero = telefoneID.getText();
            String endereco = enderecoID.getText();
            String email = emailID.getText();
            String pacote = pacoteID.getValue();
            String plano = planoID.getValue();

            LocalDate dataaux = nascimentoID.getValue();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String data = dataaux.format(formatter);
            
            String cpfaux = cpfID.getText();


            Long telefone = Long.parseLong(numero);
            Long cpf = Long.parseLong(cpfaux);

            
            if (nome.isEmpty() || numero.isEmpty() || endereco.isEmpty() || email.isEmpty() || cpfaux.isEmpty()) {
                a.setAlertType(AlertType.WARNING);
                a.setContentText("Nenhum campo pode estar vazio");
                a.show();
            }
            else if (MatriculaDAO.consultaPorCPF(cpf) != null) {
                a.setAlertType(AlertType.WARNING);
                a.setContentText("Aluno ja cadastrado");
                a.show();
            }
            else {
                MatriculaService.adicionarMatricula(nome, cpf, data, endereco, telefone, email, plano, pacote);
                carregarTabela();
                limpaInputs();
            }
        } catch (Exception e) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("Telefone/CPF/ não podem conter letras");
            a.show();
        }
    }
    
    public void carregarTabela() {
        tabelaID.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tabelaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tabelaCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tabelaNascimento.setCellValueFactory(new PropertyValueFactory<>("datanascimento"));
        tabelaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        tabelaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        tabelaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tabelaPlano.setCellValueFactory(new PropertyValueFactory<>("plano"));
        tabelaPacote.setCellValueFactory(new PropertyValueFactory<>("pacote"));

        tabela.setItems(MatriculaDAO.getobservableListMatriculas());
    }

    public void limpaInputs(){
        nomeID.setText("");
        telefoneID.setText("");
        enderecoID.setText("");
        emailID.setText("");
        nascimentoID.setValue(null);
        cpfID.setText("");
    }
    Integer codigo;
    public Integer getRow() {
        MatriculaDTO dto = tabela.getSelectionModel().getSelectedItem();
        return codigo = dto.getCodigo();
    }
}
