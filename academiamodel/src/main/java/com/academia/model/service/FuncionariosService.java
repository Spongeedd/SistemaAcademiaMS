package com.academia.model.service;

import com.academia.model.dto.FuncionariosDTO;
import com.academia.model.dao.FuncionariosDAO;
import java.sql.Date;

public class FuncionariosService {
    public static FuncionariosDTO adicionarFuncionario(String nome, String cpf, Date datanascimento, String endereco, String telefone, String email, Integer jornada, Integer phora) {
        return FuncionariosDAO.inserirFuncionarios(nome, cpf, datanascimento, endereco, telefone, email, jornada, phora);
    }

    public static void removerFuncionario(Integer codigo) {
        FuncionariosDAO.removeFuncionario(codigo);
    }

    public static void editarFuncionario(Integer codigo,  String nome, String cpf, Date data, String endereco, String telefone, String email, Integer jornada, Integer phora) {
        FuncionariosDAO.atualizaFuncionario(codigo ,nome, cpf, data, endereco, telefone, email, jornada, phora);
    }

    public static Integer consultaPorID(Integer codigo) {
        return FuncionariosDAO.consultaPorID(codigo);
    }

    public static String consultaPorNome(String nome) {
        return FuncionariosDAO.consultaPorNome(nome);
    }

    public static String consultaPorCPF(String cpf) {
        return FuncionariosDAO.consultaPorCPF(cpf);
    }
}
