package pt.iade.juliadisconzi.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import pt.iade.juliadisconzi.project.R;

public class FormLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        Button btnLogin = findViewById(R.id.bt_entrar);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Simulação de login bem-sucedido
                // Se o login for bem-sucedido, inicie a próxima atividade (FormRegistro)
                Intent intent = new Intent(FormLogin.this, FormRegistro.class);
                startActivity(intent);
            }
        });
    }
}
