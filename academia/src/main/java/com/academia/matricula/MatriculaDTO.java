package com.academia.matricula;

import java.sql.Date;

public class MatriculaDTO {
    private String nome, endereco, email, plano, pacote, cpf, telefone;
    private Date datanascimento;
    private Integer codigo;

    public MatriculaDTO(String nome, String endereco, String email, String cpf, String telefone, Date datanascimento, String plano, String pacote) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.datanascimento = datanascimento;
        this.email = email;
        this.endereco = endereco;
        this.pacote = pacote;
        this.plano = plano;
    }

    public MatriculaDTO(Integer codigo, String nome, String cpf, Date datanascimento, String email, String telefone, String endereco, String plano, String pacote) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.datanascimento = datanascimento;
        this.email = email;
        this.telefone = telefone; 
        this.plano = plano;
        this.pacote = pacote;
    }

    ////////////////////////////////////////////////////
    // Setters


    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
      return codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public void setPacote(String pacote) {
        this.pacote = pacote;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    ////////////////////////////////////////////////////
    // Getters

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getPacote() {
        return pacote;
    }
    
    public String getPlano() {
        return plano;
    }
}