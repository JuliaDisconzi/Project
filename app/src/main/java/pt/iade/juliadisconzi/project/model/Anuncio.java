package pt.iade.juliadisconzi.project.model;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

import pt.iade.juliadisconzi.project.R;

public class Anuncio {

    private int id;
    private String descricao;
    private String preco;
    private Drawable imagem;

    public Anuncio(int id, String descricao, String preco, Drawable imagem) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.imagem = imagem;
    }

    public static ArrayList<Anuncio> List(Context context) {
        ArrayList<Anuncio> listaanuncios = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            Drawable drawable = context.getDrawable(R.drawable.livro2);
            listaanuncios.add(new Anuncio(i, "Livro Algoritmos e lógica de programação em C " + i, "5€ " + i, drawable));
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
