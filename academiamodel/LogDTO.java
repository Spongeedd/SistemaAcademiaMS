package com.academia.model.dto;

import java.sql.Timestamp;

public class LogDTO {
    private String acao, usuario;
    private Timestamp data;


    public LogDTO(String acao, String usuario, Timestamp data) {
        this.acao = acao;
        this.usuario = usuario;
        this.data = data;
    }
    public LogDTO() {
    }

    public LogDTO(String string, String string2, String string3) {
    }
    
    public String getAcao() {
        return acao;
    }
    public void setAcao(String acao) {
        this.acao = acao;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public Timestamp getData() {
        return data;
    }
    public void setData(Timestamp data) {
        this.data = data;
    }

    
}
