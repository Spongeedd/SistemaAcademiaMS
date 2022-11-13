package com.academia.model.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class CatracaDTO {
    Integer ID;
    String nome;
    Timestamp data;

  public CatracaDTO(String nome, Timestamp data, Integer ID) {
    this.nome = nome;
    this.data = data;
    this.ID = ID;
  }

  public Integer getID() {
    return ID;
 }
  public void setID(Integer ID) {
    this.ID = ID;
 }

  public String getNome() {
    return nome;
 }
  public void setNome(String nome) {
    this.nome = nome;
 }

  public Timestamp getData() {
    return data;
 }
  public void setData(Timestamp data) {
    this.data = data;
 }
}