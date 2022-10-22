package com.academia.funcionario;

public class FuncionariosDTO {
    private String nome, endereco, email, datanascismento;
    private Long  cpf, telefone;
    private Integer codigo, jornada, phora;

    public FuncionariosDTO(Integer codigo, String nome, String endereco, String email, Long cpf, Long telefone, String datanascismento, Integer jornada, Integer phora) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.datanascismento = datanascismento;
        this.email = email;
        this.endereco = email;
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
    public void setDatanascismento(String datanascismento) {
        this.datanascismento = datanascismento;
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
    public String getDatasnacismento() {
        return datanascismento;
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
