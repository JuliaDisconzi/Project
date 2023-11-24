package pt.iade.juliadisconzi.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import pt.iade.juliadisconzi.project.adapters.AnuncioAdapter;
import pt.iade.juliadisconzi.project.models.Anuncio;

public class FormPesquisar extends AppCompatActivity {

    protected RecyclerView itemsListView;
    protected AnuncioAdapter itemRowAdapter;
    protected ArrayList<Anuncio> itemsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pesquisar);


        // Set up row adapter with our items list.
        itemRowAdapter = new AnuncioAdapter(this, itemsList);
        itemRowAdapter.setOnClickListener(new AnuncioAdapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // Place our clicked item object in the intent to send to the other activity.
                Intent intent = new Intent(FormPesquisar.this, ItemEditorActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("item", itemsList.get(position));

                startActivity(intent);
            }
        });

        // Set up the items recycler view.
        itemsListView = (RecyclerView) findViewById(R.id.recycler_anuncios);
        itemsListView.setLayoutManager(new LinearLayoutManager(this));
        itemsListView.setAdapter(itemRowAdapter);
    }
}