package com.academia.matricula;

public class MatriculaService {

    public static MatriculaDTO adicionarMatricula(String nome, Long cpf, String datanascimento, String endereco, Long telefone, String email, String plano, String pacote) {
        return MatriculaDAO.inserirMatricula(nome, cpf, datanascimento, endereco, telefone, email, plano, pacote);
    }

    public static void removerMatricula(Integer codigo) {
        MatriculaDAO.removeMatricula(codigo);
    }

    public static void editarMatricula(Integer codigo,String nome, Long cpf, String datanascimento, String endereco, Long telefone, String email, String plano, String pacote) {
        MatriculaDAO.atualizaMatricula(codigo ,nome, cpf, datanascimento, endereco, telefone, email, plano, pacote);
    }
}
