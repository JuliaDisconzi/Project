package pt.iade.juliadisconzi.project;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import pt.iade.juliadisconzi.project.R;
import pt.iade.juliadisconzi.project.views.FormFeed;

public class form_new_ad extends AppCompatActivity {

    private static final int CAMERA_REQUEST_CODE = 22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_new_ad);


        ImageButton imageButton = findViewById(R.id.imageButton5);
        ImageButton imageButton1 = findViewById(R.id.button_feed2);
        ImageButton imageButton2 = findViewById(R.id.imageButton2);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(form_new_ad.this, FormPesquisar.class);
                startActivity(intent);
            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(form_new_ad.this, FormFeed.class);
                startActivity(intent);
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(form_new_ad.this, FormPerfil.class);
                startActivity(intent);
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_REQUEST_CODE);
            }
        });

        Spinner localidadeSpinner = findViewById(R.id.localidadeSpinner);
        ArrayAdapter<CharSequence> localidadeSpinnerAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.location_list,
                android.R.layout.simple_spinner_item
        );
        localidadeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        localidadeSpinner.setAdapter(localidadeSpinnerAdapter);

        Spinner categorySpinner = findViewById(R.id.categorySpinner);
        ArrayAdapter<CharSequence> categorySpinnerAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.category_list,
                android.R.layout.simple_spinner_item
        );
        categorySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(categorySpinnerAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
