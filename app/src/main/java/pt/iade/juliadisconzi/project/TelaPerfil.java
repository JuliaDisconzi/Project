package pt.iade.juliadisconzi.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class TelaPerfil extends AppCompatActivity {

    private ImageButton btngotofeed;
    private ImageButton btnnewad;
    private ImageButton btnpesquisar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_perfil);

        setupComponents();
    }

    private void setupComponents() {
        btngotofeed = findViewById(R.id.button_feed);
        btnnewad = findViewById(R.id.buttonNextScreen);
        btnpesquisar = findViewById(R.id.imageButton12);

        btngotofeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaPerfil.this, FormFeed.class));
            }
        });

        btnnewad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaPerfil.this, form_new_ad.class));
            }
        });

        btnpesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaPerfil.this, FormPesquisar.class));
            }
        });


    }
}
