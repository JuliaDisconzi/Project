package pt.iade.juliadisconzi.project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.content.Intent;

public class FormPerfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_perfil);

        ImageButton buttonNextScreen = findViewById(R.id.buttonNextScreen);

                buttonNextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormPerfil.this, form_new_ad.class); // Seu novo activity
                startActivity(intent);
            }
        });
    }
}
