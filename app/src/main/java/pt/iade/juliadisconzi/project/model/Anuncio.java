package pt.iade.juliadisconzi.project.model;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

public class Anuncio {

    private int id;
    private String descricao;
    private String preco;
    private Drawable imagem;

    public Anuncio(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static ArrayList<Anuncio> List() {
        ArrayList<Anuncio> listaanuncios = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            listaanuncios.add(new Anuncio(i,String.valueOf(i)));
        }

        return listaanuncios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



    public int getModelo() {
        return 0;
    }

    public String getPreco() {
        return preco;
    }


    public void setPreco(String preco) {
        this.preco = preco;
    }

    public Drawable getImagem() {
        return imagem;
    }

    public void setImagem(Drawable imagem) {
        this.imagem = imagem;
    }

}
