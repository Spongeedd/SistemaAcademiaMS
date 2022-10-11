/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aluno
 */

    
    public class Matricula {
    private String nomeCompleto, telefone, tipo, email, CPF, Nascimento;
    private Integer codigo;

    public Matricula () {}

    public Matricula(Integer codigo, String nomeCompleto, String telefone, String tipo, String email, String CPF, String Nascimento) {
        this.codigo = codigo;
        this.nomeCompleto = nomeCompleto;
        this.CPF = CPF;
        this.Nascimento = Nascimento;
        this.email = email;
        this.telefone = telefone; 
        this.tipo = tipo;
     
    }

    ////////////////////////////////////////////////////
    // Setters

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
      return codigo;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setNascimento(String Nascimento) {
        this.Nascimento = Nascimento;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEmail() {
        return email;
    }

    public String getCPF() {
        return CPF;
    }

    public String getNascimento() {
        return Nascimento;
    }
    
}
    