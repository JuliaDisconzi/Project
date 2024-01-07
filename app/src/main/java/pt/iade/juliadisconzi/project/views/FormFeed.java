package pt.iade.juliadisconzi.project.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import pt.iade.juliadisconzi.project.FormConversas;
import pt.iade.juliadisconzi.project.FormPerfil;
import pt.iade.juliadisconzi.project.FormPesquisar;
import pt.iade.juliadisconzi.project.R;
import pt.iade.juliadisconzi.project.adapters.AnuncioAdapter;
import pt.iade.juliadisconzi.project.form_new_ad;
import pt.iade.juliadisconzi.project.model.Anuncio;


public class FormFeed extends AppCompatActivity {

    ImageButton btngotofeed;
    ImageButton btngopesquisar;
    ArrayList<Anuncio> listAnuncios;
    ImageButton btnadanuncio;
    ImageButton btnmensagem;
    ViewHolder mViewHolder = new ViewHolder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_feed);

        btnadanuncio = (ImageButton) findViewById(R.id.imageButton3);
        btnadanuncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormFeed.this, form_new_ad.class);
                startActivity(intent);
            }
        });

        btnmensagem = (ImageButton) findViewById(R.id.imageButton4);
        btnmensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormFeed.this, FormConversas.class);
                startActivity(intent);
            }
        });

        btngotofeed = (ImageButton) findViewById(R.id.feed_profile_button);
        btngotofeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormFeed.this, FormPerfil.class);
                startActivity(intent);
            }
        });
        btngopesquisar = (ImageButton) findViewById(R.id.button_pesquisar);
        btngopesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormFeed.this, FormPesquisar.class);
                startActivity(intent);
            }
        });

        mViewHolder.recycler_view = findViewById(R.id.recycler_view);

        listAnuncios = Anuncio.List(this);


        AnuncioAdapter anuncioAdapter = new AnuncioAdapter(listAnuncios);
        mViewHolder.recycler_view.setAdapter(anuncioAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mViewHolder.recycler_view.setLayoutManager(linearLayoutManager);
    }




    private static class ViewHolder{
        RecyclerView recycler_view;
    }
}