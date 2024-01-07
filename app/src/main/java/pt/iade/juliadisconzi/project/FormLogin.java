package pt.iade.juliadisconzi.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import pt.iade.juliadisconzi.project.views.FormFeed;

public class FormLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        Button btnregistro = findViewById(R.id.button_criar_conta);
        Button btnentrar = findViewById(R.id.button_entrar);

        btnregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormLogin.this, FormRegistro.class);
                startActivity(intent);
            }
        });

        btnentrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarEmailExistente();
            }
        });
    }

    private void verificarEmailExistente() {
        EditText editEmail = findViewById(R.id.edit_email);
        String email = editEmail.getText().toString().trim();

        List<String> emailsCadastrados = new ArrayList<>();
        emailsCadastrados.add("judisconzi@gmail.com");

        if (emailsCadastrados.contains(email)) {
            Toast.makeText(FormLogin.this, "Email já cadastrado", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(FormLogin.this, FormFeed.class);
            startActivity(intent);
        }
    }
}
