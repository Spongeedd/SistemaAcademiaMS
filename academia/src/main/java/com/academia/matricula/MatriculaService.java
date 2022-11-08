package com.academia.matricula;

import java.sql.Date;

public class MatriculaService {
    public static MatriculaDTO adicionarMatricula(String nome, Long cpf, String datanascimento, String endereco, Long telefone, String email, String plano, String pacote) {

    public static MatriculaDTO adicionarMatricula(String nome, String cpf, Date datanascimento, String endereco, String telefone, String email, String plano, String pacote) {
        return MatriculaDAO.inserirMatricula(nome, cpf, datanascimento, endereco, telefone, email, plano, pacote);
    }

    public static void delMatr(Integer codigo) {
        MatriculaDAO.delMatr(codigo);
    }

    public static void editarMatricula(Integer codigo,String nome, String cpf, Date datanascimento, String endereco, String telefone, String email, String plano, String pacote) {
        MatriculaDAO.atualizaMatricula(codigo ,nome, cpf, datanascimento, endereco, telefone, email, plano, pacote);
    }
}

    public static Integer consultaPorID(Integer codigo) {
        return MatriculaDAO.consultaPorID(codigo);
    }

    public static String consultaPorNome(String nome) {
        return MatriculaDAO.consultaPorNome(nome);
    }

    public static String consultaPorCPF(String cpf) {
        return MatriculaDAO.consultaPorCPF(cpf);
    }
}