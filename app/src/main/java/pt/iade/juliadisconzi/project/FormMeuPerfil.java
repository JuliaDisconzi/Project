package pt.iade.juliadisconzi.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class FormMeuPerfil extends AppCompatActivity {

    private ImageButton btnvoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_meu_perfil);
        setupComponents();


        SharedPreferences sharedPreferences = getSharedPreferences("INFO_USUARIO", MODE_PRIVATE);

        String nome = sharedPreferences.getString("nome", "Nome Padrão");
        String email = sharedPreferences.getString("email", "Email Padrão");
        String senha = sharedPreferences.getString("senha", "Senha Padrão");


        TextView textViewNome = findViewById(R.id.textView_nome);
        TextView textViewEmail = findViewById(R.id.email_text);
        TextView textViewSenha = findViewById(R.id.contacto_telemovel);

        textViewNome.setText(nome);
        textViewEmail.setText(email);
        textViewSenha.setText(senha);
    }


    private void setupComponents () {
        btnvoltar = findViewById(R.id.imageButton_voltar);

        btnvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormMeuPerfil.this, FormPerfil.class));
            }
        });
    }
}