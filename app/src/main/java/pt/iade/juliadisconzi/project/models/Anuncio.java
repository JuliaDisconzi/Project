package pt.iade.juliadisconzi.project.models;

import java.io.Serializable;

public class Anuncio implements Serializable {
    private String titulo;
    private String descricao;

    public Anuncio(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

}
