package com.academia.matricula;

public class MatriculaDTO {
    private String nome, endereco, email, datanascimento, plano, pacote;
    private Long  cpf, telefone;
    private Integer codigo;

    public MatriculaDTO () {}

    public MatriculaDTO(Integer codigo, String nome, Long cpf, String datanascimento, String email, Long telefone, String endereco, String plano, String pacote) {
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

    public void setnome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setcpf(Long cpf) {
        this.cpf = cpf;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setdatanascimento(String datanascimento) {
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

    public String getnome() {
        return nome;
    }

    public Long getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public Long getcpf() {
        return cpf;
    }

    public String getdatanascimento() {
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