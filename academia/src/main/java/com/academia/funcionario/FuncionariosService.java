package com.academia.funcionario;

public class FuncionariosService {
    public static FuncionariosDTO adicionarFuncionario(String nome, Long cpf, String datanascimento, String endereco, Long telefone, String email, Integer jornada, Integer phora) {
        return FuncionariosDAO.inserirFuncionarios(nome, cpf, datanascimento, endereco, telefone, email, jornada, phora);
    }
}
