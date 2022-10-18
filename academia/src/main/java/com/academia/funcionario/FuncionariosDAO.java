package com.academia.funcionario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FuncionariosDAO {
    private static ObservableList<FuncionariosDTO> observableListClientes;
    private static List<FuncionariosDTO> funcionarioLista;
    private static Integer codigo;
    static {
        funcionarioLista = new ArrayList<>();
        codigo = 1;
    }

    public static FuncionariosDTO inserirFuncionarios(String nome, Long cpf, Date datanascimento, String endereco, Long telefone, String email, Integer jornada, Integer phora) {
        while (consultaPorID(codigo)!= null) {
            codigo++;
        }
        FuncionariosDTO funcionario = new FuncionariosDTO(nome, endereco, email, cpf, telefone, datanascimento, jornada, phora);
        funcionarioLista.add(funcionario);
        codigo++;
        observableListClientes = FXCollections.observableArrayList(funcionarioLista);
        return funcionario;
    }
    static List<FuncionariosDTO> toRemove = new ArrayList();
    public static void removeFuncionario(Integer cdg) {
        for (FuncionariosDTO c: funcionarioLista){
            if (c.getCodigo().equals(cdg)){
                toRemove.add(c);
                codigo = c.getCodigo();
            }
        }
        funcionarioLista.removeAll(toRemove);
        observableListClientes = FXCollections.observableArrayList(funcionarioLista);
    }

    public static void atualizaFuncionario(Integer codigo, String nome, Long cpf, Date datanascimento, String endereco, Long telefone, String email, Integer jornada, Integer phora) {
        for (FuncionariosDTO c: funcionarioLista){
            if (c.getCodigo().equals(codigo)){
                c.setNome(nome);
                c.setTelefone(telefone);
                c.setEmail(email);
                c.setCpf(telefone);
            }
        }
        observableListClientes = FXCollections.observableArrayList(funcionarioLista);
    }

    public static FuncionariosDTO consultaPorNome(String nome) {
        for (FuncionariosDTO c: funcionarioLista){
            if (c.getNome().equals(nome)){
                return c;
            }
        }
        return null;
    }

    public static FuncionariosDTO consultaPorID(Integer codigo) {
        for (FuncionariosDTO c: funcionarioLista){
            if (c.getCodigo().equals(codigo)){
                return c;
            }
        }
        return null;
    }

    public static FuncionariosDTO consultaPorNumero(Long telefone) {
        for (FuncionariosDTO c: funcionarioLista){
            if (c.getTelefone().equals(telefone)){
                return c;
            }
        }
        return null;
    }

    public static Integer getCodigo() {
        return codigo;
    }

    public static ObservableList<FuncionariosDTO> getObservableListClientes() {
        return observableListClientes;
    }
}

