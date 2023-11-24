package pt.iade.juliadisconzi.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class FormFeed extends AppCompatActivity {

    private ImageButton btngonovoanuncio;
    private ImageButton btngoperfil;
    private ImageButton btngopesquisar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_feed);

        setupComponents();
    }

    private void setupComponents() {
        btngonovoanuncio = findViewById(R.id.imageButton3);
        btngonovoanuncio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormFeed.this, form_new_ad.class));
            }
        });

        btngoperfil = findViewById(R.id.imageButton2);
        btngoperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormFeed.this, TelaPerfil.class));
            }
        });

        btngopesquisar = findViewById(R.id.imageButton7);
        btngopesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormFeed.this, FormPesquisar.class));
            }
        });
    }
}
