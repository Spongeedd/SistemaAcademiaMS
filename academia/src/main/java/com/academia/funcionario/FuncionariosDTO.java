package com.academia.funcionario;

public class FuncionariosDTO {
    private String nome, endereco, email, datanascimento;
    private Long  cpf, telefone;
    private Integer codigo, jornada, phora;

    public FuncionariosDTO(Integer codigo, String nome, String endereco, String email, Long cpf, Long telefone, String datanascimento, Integer jornada, Integer phora) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.datanascimento = datanascimento;
        this.email = email;
        this.endereco = endereco;
        this.jornada = jornada;
        this.phora = phora;
    }

    // Setters

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setJornada(Integer jornada) {
        this.jornada = jornada;
    }
    public void setPhora(Integer phora) {
        this.phora = phora;
    }
    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    ///////////////////////////////////////////////////
    // Getters

    public Integer getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public Long getCpf() {
        return cpf;
    }
    public String getDatanascimento() {
        return datanascimento;
    }
    public String getEmail() {
        return email;
    }
    public String getEndereco() {
        return endereco;
    }
    public Integer getJornada() {
        return jornada;
    }
    public Integer getPhora() {
        return phora;
    }
    public Long getTelefone() {
        return telefone;
    }
}
