package pt.iade.juliadisconzi.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pt.iade.juliadisconzi.project.views.FormFeed;


public class FormRegistro extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_registro);

        Button btnregistrar = findViewById(R.id.button);

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextEmail = findViewById(R.id.edit_email);
                EditText editTextSenha = findViewById(R.id.edit_senha);

                String email = editTextEmail.getText().toString().trim();
                String senha = editTextSenha.getText().toString().trim();

                if (isValidEmail(email)) {
                    String nome = ((EditText) findViewById(R.id.nome)).getText().toString();

                    SharedPreferences sharedPreferences = getSharedPreferences("INFO_USUARIO", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("nome", nome);
                    editor.putString("email", email);
                    editor.putString("senha", senha);
                    editor.apply();

                    Intent intent = new Intent(FormRegistro.this, FormFeed.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    FormRegistro.this.finish();
                } else {
                    Toast.makeText(FormRegistro.this, "Insira um email válido", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
        return email.matches(regex);
    }
}
