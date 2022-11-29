package com.academia.model.dto;

public class ExerciciosDTO {
    private Integer id;
    private String plano, descricao, serie, repeticoes;
    
    public ExerciciosDTO (Integer id, String descricao, String plano){
        this.id = id;
        this.descricao = descricao;
        this.plano = plano;
    }

    public ExerciciosDTO(Integer id, String plano, String descricao, String serie, String repeticoes) {
        this.id = id;
        this.plano = plano;
        this.descricao = descricao;
        this.serie = serie;
        this.repeticoes = repeticoes;
    }

    public ExerciciosDTO(String plano, String descricao, String serie, String repeticoes) {
        this.plano = plano;
        this.descricao = descricao;
        this.serie = serie;
        this.repeticoes = repeticoes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(String repeticoes) {
        this.repeticoes = repeticoes;
    }

}
