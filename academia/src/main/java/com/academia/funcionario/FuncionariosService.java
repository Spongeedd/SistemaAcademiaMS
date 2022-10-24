package com.academia.funcionario;

public class FuncionariosService {
    public static FuncionariosDTO adicionarFuncionario(String nome, Long cpf, String datanascimento, String endereco, Long telefone, String email, Integer jornada, Integer phora) {
        return FuncionariosDAO.inserirFuncionarios(nome, cpf, datanascimento, endereco, telefone, email, jornada, phora);
    }

    public static void removerFuncionario(Integer codigo) {
        FuncionariosDAO.removeFuncionario(codigo);
    }

    public static void editarFuncionario(Integer codigo,  String nome, Long cpf, String datanascimento, String endereco, Long telefone, String email, Integer jornada, Integer phora) {
        FuncionariosDAO.atualizaFuncionario(codigo ,nome, cpf, datanascimento, endereco, telefone, email, jornada, phora);
    }
}