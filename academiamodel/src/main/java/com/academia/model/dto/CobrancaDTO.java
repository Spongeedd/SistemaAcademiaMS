package com.academia.model.dto;

import java.sql.Date;


public class CobrancaDTO {
    private Integer id, idboleto ,valor;
    private Date vencimento;

    public CobrancaDTO(Integer idboleto, Integer valor, Date vencimento) {
        this.idboleto = idboleto;
        this.valor = valor;
        this.vencimento = vencimento;
    }
    public CobrancaDTO() {
    }

    public Integer getIdboleto() {
        return idboleto;
    }
    public void setIdboleto(Integer idboleto) {
        this.idboleto = idboleto;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getValor() {
        return valor;
    }
    public void setValor(Integer valor) {
        this.valor = valor;
    }
    public Date getVencimento() {
        return vencimento;
    }
    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    
}
