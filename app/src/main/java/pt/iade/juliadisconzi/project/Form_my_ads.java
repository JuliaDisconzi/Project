package pt.iade.juliadisconzi.project;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pt.iade.juliadisconzi.project.adapters.MeusAnunciosAdapter;
import pt.iade.juliadisconzi.project.model.MeusAnunciosModel;

public class Form_my_ads extends AppCompatActivity {

    private static final int YOUR_REQUEST_CODE = 123;
    private RecyclerView recyclerView;
    private MeusAnunciosAdapter adapter;
    private List<MeusAnunciosModel> anunciosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_my_ads);

        recyclerView = findViewById(R.id.recyclerview_meusanuncios);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        anunciosList = new ArrayList<>();

        adapter = new MeusAnunciosAdapter(this, anunciosList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == YOUR_REQUEST_CODE && resultCode == RESULT_OK) {

            MeusAnunciosModel novoAnuncio = new MeusAnunciosModel();
            novoAnuncio.setTitulo(data.getStringExtra("titulo"));
            novoAnuncio.setPreco(data.getStringExtra("preco"));
            novoAnuncio.setImagePath(data.getStringExtra("caminho_imagem"));

            if (anunciosList != null) {
                anunciosList.add(novoAnuncio);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
