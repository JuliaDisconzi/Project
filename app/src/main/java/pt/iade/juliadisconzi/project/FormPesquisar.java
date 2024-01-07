package pt.iade.juliadisconzi.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import pt.iade.juliadisconzi.project.views.FormFeed;

public class FormPesquisar extends AppCompatActivity {



    private ImageButton btnvoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pesquisar);


        setupComponents();


        }
        private void setupComponents(){
            btnvoltar = findViewById(R.id.botao_voltar);

            btnvoltar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(FormPesquisar.this, FormFeed.class));
                }
            });
        }

    }
