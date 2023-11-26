package pt.iade.juliadisconzi.project.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import pt.iade.juliadisconzi.project.R;
import pt.iade.juliadisconzi.project.adapters.AnuncioAdapter;
import pt.iade.juliadisconzi.project.data.anuncioMock;
import pt.iade.juliadisconzi.project.model.Anuncio;

public class FormFeed extends AppCompatActivity {

    ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_feed);

        mViewHolder.recycler_view = findViewById(R.id.recycler_view);

        anuncioMock anunciomock = new anuncioMock();
        List<Anuncio> listaAnuncios = new ArrayList<>();
        listaAnuncios.addAll(anunciomock.getListaanuncios());


        AnuncioAdapter anuncioAdapter = new AnuncioAdapter(listaAnuncios);
        mViewHolder.recycler_view.setAdapter(anuncioAdapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mViewHolder.recycler_view.setLayoutManager(linearLayoutManager);
    }

    private static class ViewHolder{
        RecyclerView recycler_view;
    }
}