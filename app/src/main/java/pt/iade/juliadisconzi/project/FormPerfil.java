package pt.iade.juliadisconzi.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import pt.iade.juliadisconzi.project.views.FormFeed;

public class FormPerfil extends AppCompatActivity {

    private ImageButton btngotofeed;
    private AppCompatButton btnnewad;
    private AppCompatImageButton btnpesquisar;
    private AppCompatButton btnclassificacao;
    private AppCompatImageButton btnmensagem;
    private AppCompatButton btnmeuperfil;
    private AppCompatButton btnmeusanuncios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_perfil);


        SharedPreferences sharedPreferences = getSharedPreferences("NOME_USUARIO", MODE_PRIVATE);
        String nomeUsuario = sharedPreferences.getString("nome", "");


        TextView textViewNome = findViewById(R.id.textView3);
        textViewNome.setText(nomeUsuario);

        setupComponents();
    }



    private void setupComponents() {
        btngotofeed = findViewById(R.id.button_feed2);
        btnnewad = findViewById(R.id.buttonNextScreen);
        btnpesquisar = findViewById(R.id.imageButton7);
        btnclassificacao = findViewById(R.id.buttonNextScreen4);
        btnmensagem = findViewById(R.id.btn_mensagem);
        btnmeuperfil = findViewById(R.id.buttonNextScreen2);
        btnmeusanuncios = findViewById(R.id.buttonNextScreen5);

        btnmeuperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormPerfil.this, FormMeuPerfil.class));
            }
        });

        btnmeusanuncios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormPerfil.this, Form_my_ads.class));
            }
        });

        btnmensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormPerfil.this, FormConversas.class));
            }
        });

        btngotofeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormPerfil.this, FormFeed.class));
            }
        });

        btnnewad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormPerfil.this, form_new_ad.class));
            }
        });

        btnpesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormPerfil.this, FormPesquisar.class));
            }
        });

        btnclassificacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormPerfil.this, FormClassificacao.class));
            }
        });


    }
}



