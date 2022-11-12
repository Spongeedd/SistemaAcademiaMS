package academiawb.model.dto;

import java.sql.Date;


public class FuncionariosDTO {
    private String nome, endereco, email, cpf, telefone;
    private Date datanascimento;
    private Integer codigo, jornada, phora, salario;

    public FuncionariosDTO(Integer codigo ,String nome, String cpf, Date datanascimento, String endereco, String telefone, String email, Integer jornada, Integer phora, Integer salario) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.datanascimento = datanascimento;
        this.email = email;
        this.endereco = endereco;
        this.jornada = jornada;
        this.phora = phora;
        this.codigo = codigo;
        this.salario = salario;
    }

    public FuncionariosDTO(String nome, String endereco, String email, String cpf, String telefone, Date datanascimento, Integer jornada, Integer phora) {
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
    public void setSalario(Integer salario) {
        this.salario = salario;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setDatanascimento(Date datanascimento) {
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
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    ///////////////////////////////////////////////////
    // Getters
    public Integer getSalario() {
        return salario;
    }
    public Integer getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public Date getDatanascimento() {
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
    public String getTelefone() {
        return telefone;
    }
}
