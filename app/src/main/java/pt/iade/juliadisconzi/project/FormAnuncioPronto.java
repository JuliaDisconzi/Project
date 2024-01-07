package pt.iade.juliadisconzi.project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import pt.iade.juliadisconzi.project.views.FormFeed;

public class FormAnuncioPronto extends AppCompatActivity {

    private TextView textViewTitulo;
    private TextView textViewPreco;
    private EditText EditTextDescricao;
    private TextView textViewContacto;
    private TextView textViewLocalidade;
    private TextView textViewCategoria;
    private ImageButton btnvoltar;
    private Button button_chat;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_anuncio_pronto);

        textViewTitulo = findViewById(R.id.titulo_anuncio);
        textViewPreco = findViewById(R.id.preco_anuncio);
        EditTextDescricao = findViewById(R.id.descricao_anuncio);
        textViewContacto = findViewById(R.id.contacto);
        textViewLocalidade = findViewById(R.id.localizacao);
        textViewCategoria = findViewById(R.id.categoria);
        button_chat = findViewById(R.id.button_conversar);
        btnvoltar = findViewById(R.id.imageButtonvoltar);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String titulo = extras.getString("titulo");
            String preco = extras.getString("preco");
            String descricao = extras.getString("descricao");
            String contacto = extras.getString("contacto");
            String localidade = extras.getString("localidade");
            String categoria = extras.getString("categoria");
            String caminhoImagem = extras.getString("caminho_imagem");


            textViewTitulo.setText(titulo);
            textViewPreco.setText(preco);
            EditTextDescricao.setText(descricao);
            textViewContacto.setText(contacto);
            textViewLocalidade.setText(localidade);
            textViewCategoria.setText(categoria);

            if (caminhoImagem != null && !caminhoImagem.isEmpty()){
                ImageView imageView = findViewById(R.id.imageView);
                File imageFile = new File(caminhoImagem);
                if (imageFile.exists()){
                    Bitmap myBitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
                    imageView.setImageBitmap(myBitmap);
                }
            }
        }

        setupComponents();
    }

    private void setupComponents() {
        button_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormAnuncioPronto.this, FormChat.class));
            }
        });

        btnvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FormAnuncioPronto.this, FormPerfil.class));
            }
        });
    }
}
