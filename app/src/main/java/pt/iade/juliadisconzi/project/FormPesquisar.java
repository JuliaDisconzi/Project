package pt.iade.juliadisconzi.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class FormPesquisar extends AppCompatActivity {



    private ImageButton btnadanuncio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pesquisar);


        setupComponents();


        }
        private void setupComponents(){
            btnadanuncio = findViewById(R.id.ad_anuncio);

            btnadanuncio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(FormPesquisar.this, form_new_ad.class));
                }
            });
        }

    }
