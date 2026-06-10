package com.aep2.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_postagem")
public class PostagemModel {

    @Id
    @GeneratedValue
    private Long id;
    private String titulo;
    private String tipoPostagem;
    private String descricaoPostagem;

    public PostagemModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTituloPostagem() {
        return titulo;
    }

    public void setTituloPostagem(String tituloPostagem) {
        this.titulo = tituloPostagem;
    }

    public String getTipoPostagem() {
        return tipoPostagem;
    }

    public void setTipoPostagem(String tipoPostagem) {
        this.tipoPostagem = tipoPostagem;
    }

    public String getDescricaoPostagem() {
        return descricaoPostagem;
    }

    public void setDescricaoPostagem(String descricaoPostagem) {
        this.descricaoPostagem = descricaoPostagem;
    }
}
