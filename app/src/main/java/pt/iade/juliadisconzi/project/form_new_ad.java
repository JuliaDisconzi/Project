package pt.iade.juliadisconzi.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import pt.iade.juliadisconzi.project.views.FormFeed;

public class form_new_ad extends AppCompatActivity {
    private Button btngoanunciar;
    private EditText edit_titulo;
    private EditText edit_preco;
    private EditText descricao;
    private EditText edit_contacto;
    private Spinner localidadeSpinner;
    private Spinner categorySpinner;
    private String imagePath;

    private static final int CAMERA_REQUEST_CODE = 22;
    private static final int YOUR_REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_new_ad);

        ImageButton imageButton5 = findViewById(R.id.imageButton5);
        ImageButton imageButton1 = findViewById(R.id.button_feed2);
        ImageButton imageButton2 = findViewById(R.id.imageButton2);


        btngoanunciar = findViewById(R.id.button_anunciar);
        edit_titulo = findViewById(R.id.edit_titulo);
        edit_preco = findViewById(R.id.edit_preco);
        descricao = findViewById(R.id.descricao);
        edit_contacto = findViewById(R.id.edit_contacto);
        localidadeSpinner = findViewById(R.id.localidadeSpinner);
        categorySpinner = findViewById(R.id.categorySpinner);

        btngoanunciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String titulo = edit_titulo.getText().toString();
                String preco = edit_preco.getText().toString();
                String desc = descricao.getText().toString();
                String contacto = edit_contacto.getText().toString();
                String localidade = localidadeSpinner.getSelectedItem().toString();
                String categoria = categorySpinner.getSelectedItem().toString();


                Intent intent = new Intent(form_new_ad.this, FormAnuncioPronto.class);
                intent.putExtra("titulo", titulo);
                intent.putExtra("preco", preco);
                intent.putExtra("descricao", desc);
                intent.putExtra("contacto", contacto);
                intent.putExtra("localidade", localidade);
                intent.putExtra("categoria", categoria);
                intent.putExtra("caminho_imagem", imagePath);




                startActivityForResult(intent, YOUR_REQUEST_CODE);
            }
        });
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(form_new_ad.this, android.Manifest.permission.CAMERA)
                        == PackageManager.PERMISSION_DENIED) {
                    ActivityCompat.requestPermissions(form_new_ad.this,
                            new String[]{android.Manifest.permission.CAMERA}, CAMERA_REQUEST_CODE);
                }

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_REQUEST_CODE);
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

            ImageButton imageButton = findViewById(R.id.imageButton5);
            imageButton.setImageBitmap(imageBitmap);

            imagePath = saveImageToStorage(imageBitmap);

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private String saveImageToStorage(Bitmap bitmap) {
        String imagePath = "";
        try {
            ContextWrapper wrapper = new ContextWrapper(getApplicationContext());
            File directory = wrapper.getDir("images", MODE_PRIVATE);
            File file = new File(directory, "temp_image.jpg");
            OutputStream stream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            stream.flush();
            stream.close();
            imagePath = file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagePath;
    }
}
