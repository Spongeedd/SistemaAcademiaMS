package com.academia.matricula;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MatriculaDAO {
    private static ObservableList<MatriculaDTO> observableListMatriculas;
    private static List<MatriculaDTO> matriculasLista;
    private static Integer codigo;
    static {
        matriculasLista = new ArrayList<>();
        codigo = 1;
    }

    public static MatriculaDTO inserirMatricula(String nome, Long cpf, String datanascimento, String endereco, Long telefone, String email, String plano, String pacote) {
        while (consultaPorID(codigo)!= null) {
            codigo++;
        }
        MatriculaDTO matricula = new MatriculaDTO(codigo, nome, cpf, datanascimento, email, telefone, endereco, plano, pacote);
        matriculasLista.add(matricula);
        codigo++;
        observableListMatriculas = FXCollections.observableArrayList(matriculasLista);
        return matricula;
    }

    static List<MatriculaDTO> toRemove = new ArrayList();
    public static void removeMatricula(Integer cdg) {
        for (MatriculaDTO c: matriculasLista){
            if (c.getCodigo().equals(cdg)){
                toRemove.add(c);
                codigo = c.getCodigo();
            }
        }
        matriculasLista.removeAll(toRemove);
        observableListMatriculas = FXCollections.observableArrayList(matriculasLista);
    }

    public static void atualizaMatricula(Integer codigo, String nome, Long cpf, String datanascimento, String endereco, Long telefone, String email, String plano, String pacote) {
        removeMatricula(codigo);
        inserirMatricula(nome, cpf, datanascimento, endereco, telefone, email, plano, pacote);
    }

    public static MatriculaDTO consultaPorNome(String nome) {
        for (MatriculaDTO c: matriculasLista){
            if (c.getNome().equals(nome)){
                return c;
            }
        }
        return null;
    }

    public static MatriculaDTO consultaPorID(Integer codigo) {
        for (MatriculaDTO c: matriculasLista){
            if (c.getCodigo().equals(codigo)){
                return c;
            }
        }
        return null;
    }

    public static MatriculaDTO consultaPorCPF(long CPF) {
        for (MatriculaDTO c: matriculasLista){
            if (c.getCpf().equals(CPF)){
                return c;
            }
        }
        return null;
    }

    public static MatriculaDTO consultaPorNumero(Long telefone) {
        for (MatriculaDTO c: matriculasLista){
            if (c.getTelefone().equals(telefone)){
                return c;
            }
        }
        return null;
    }

    public static Integer getCodigo() {
        return codigo;
    }

    public static ObservableList<MatriculaDTO> getobservableListMatriculas() {
        return observableListMatriculas;
    }
}
