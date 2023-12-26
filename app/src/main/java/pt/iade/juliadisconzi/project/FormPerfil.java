package pt.iade.juliadisconzi.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import pt.iade.juliadisconzi.project.views.FormFeed;

public class FormPerfil extends AppCompatActivity {

    private ImageButton btngotofeed;
    private AppCompatButton btnnewad;
    private ImageButton btnpesquisar;
    private AppCompatButton btnclassificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_perfil);

        setupComponents();
    }

    private void setupComponents() {
        btngotofeed = findViewById(R.id.button_feed2);
        btnnewad = findViewById(R.id.buttonNextScreen);
        btnpesquisar = findViewById(R.id.imageButton7);
        btnclassificacao = findViewById(R.id.buttonNextScreen4);

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



