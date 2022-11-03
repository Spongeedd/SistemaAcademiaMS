package com.academia.matricula;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import com.academia.App;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

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

    @FXML
    private ChoiceBox<String> buscarSelect;

    @FXML
    private TextField buscarInput;

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

    @FXML
    private Button buscarBTN;

    @FXML
    private Button inicioBTN;



    private String[] pacoteStrings = {"Mensal", "Trimestral", "Anual"};
    private String[] planoStrings = {"Basico", "Intermediário", "Premium"};
    private String[] buscarSelStrings = {"ID", "Nome", "CPF"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pacoteID.setValue("Mensal");
        pacoteID.getItems().addAll(pacoteStrings);
        planoID.setValue("Basico");
        planoID.getItems().addAll(planoStrings);
        buscarSelect.setValue("ID");
        buscarSelect.getItems().addAll(buscarSelStrings);
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

    @FXML
    private void removerBTN() throws IOException {
        try {
            MatriculaService.removerMatricula(getRow());
            carregarTabela();
        } catch (Exception e) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("Nenhuma matrícula selecionada");
            a.show();
        }
    }

    @FXML
    private void atualizarBTN() throws IOException {
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
                MatriculaService.editarMatricula(getRow(), nome, cpf, data, endereco, telefone, email, plano, pacote);
                carregarTabela();
                limpaInputs();
            }
        } catch (Exception e) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("Nenhum contato selecionado");
            a.show();
        }
    }

    
    @FXML
    private void removerBTN() throws IOException {
        try {
            MatriculaService.delMatr(getRow());
            carregarTabela();
        } catch (Exception e) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("Nenhuma matrícula selecionado");
            a.show();
        }
    }

    @FXML
    private void atualizarBTN() throws IOException {
        try {
            String nome = nomeID.getText();
            String numero = telefoneID.getText();
            String endereco = enderecoID.getText();
            String email = emailID.getText();
            String pacote = pacoteID.getValue();
            String plano = planoID.getValue();
            String datanascimento = nascimentoID.getValue();

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
                a.setContentText("Matrícula existente");
                a.show();
            }
            else {
                MatriculaService.editarMatricula(getRow(), nome, cpf, datanascimento, endereco, telefone, email, plano, pacote);
                carregarTabela();
                limpaInputs();
            }
        } catch (Exception e) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("Nenhuma matrícula selecionado");
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

    @FXML
    private void voltarBTN() throws IOException {
        Stage stage = new Stage();
            Parent root = FXMLLoader.load(App.class.getResource("InterfaceLogin.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Cadastrar Funcionario");
        stage.setResizable(false);
        stage.getIcons().add(new Image(App.class.getResourceAsStream("icone.png")));
        stage.show();
        stage = (Stage) inicioBTN.getScene().getWindow();
        stage.close();
    }


    @FXML
    private void buscarBTN() throws IOException {
        try {
            String buscaInput = buscarInput.getText();
            String buscaSelect = buscarSelect.getValue();
            MatriculaDTO consulta;
            if (buscaInput.isEmpty()) {
                a.setAlertType(AlertType.WARNING);
                a.setContentText("Campo não pode estar vazio");
                a.show();
            }
            else {
                switch (buscaSelect) {
                    case "ID":
                            Integer id = Integer.parseInt(buscaInput);
                            consulta = MatriculaService.consultaPorID(id);
                            if (consulta == null) {
                                a.setAlertType(AlertType.WARNING);
                                a.setContentText("ID não encontrado");
                                a.show();
                            }
                            else {
                                a.setAlertType(AlertType.INFORMATION);
                                a.setContentText(textoConsulta(consulta));
                                a.show();
                            }
                        break;
                    case "Nome":
                        consulta = MatriculaService.consultaPorNome(buscaInput);
                        if (consulta == null) {
                            a.setAlertType(AlertType.WARNING);
                            a.setContentText("Nome não encontrado");
                            a.show();
                        }
                        else {
                            a.setAlertType(AlertType.INFORMATION);
                            a.setContentText(textoConsulta(consulta));
                            a.show();
                        }
                        break;
                    case "CPF":
                        try {
                            Long cpf = Long.parseLong(buscaInput);
                            consulta = MatriculaService.consultaPorCPF(cpf);
                            if (consulta == null) {
                                a.setAlertType(AlertType.WARNING);
                                a.setContentText("CPF não encontrado");
                                a.show();
                            }
                            else {
                                a.setAlertType(AlertType.INFORMATION);
                                a.setContentText(textoConsulta(consulta));
                                a.show();
                            }
                        } catch (Exception e) {
                            a.setAlertType(AlertType.WARNING);
                            a.setContentText("CPF");
                            a.show();
                        }
                        break;
                    }
                }
        }catch (Exception e) {
            a.setAlertType(AlertType.WARNING);
            a.setContentText("ID deve ser um número");
            a.show();
        }
    }

    private String textoConsulta (MatriculaDTO consulta) {
        String nome, email, pacote, plano;
        Integer ID;
        Long numero, cpf;
        ID = consulta.getCodigo();
        nome = consulta.getNome();
        cpf = consulta.getCpf();
        numero = consulta.getTelefone();
        email = consulta.getEmail();
        plano = consulta.getPlano();
        pacote = consulta.getPacote();
        String textoconsultaString = "ID: " + ID + "\nNome: " + nome + "\nCPF: " + cpf + "\nNúmero: " + numero + "\nEmail: " + email+ "\nPlano: " + plano + "\nPacote: " + pacote;
        return textoconsultaString;
    }
}
