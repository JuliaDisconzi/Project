package pt.iade.juliadisconzi.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FormLogin extends AppCompatActivity {
    private TextView text_tela_registro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        getSupportActionBar().hide();
        IniciarComponentes();
        text_tela_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(FormLogin.this, FormRegistro.class);
                startActivity(intent);
            }
        });
    }

    private void IniciarComponentes(){
        text_tela_registro = findViewById(R.id.text_tela_registro);
    }
}