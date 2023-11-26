package pt.iade.juliadisconzi.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                Intent intent = new Intent(FormRegistro.this, FormFeed.class);
                startActivity(intent);
            }
        });



    }
}
