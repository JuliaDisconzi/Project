package pt.iade.juliadisconzi.project.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pt.iade.juliadisconzi.project.FormAnuncioPronto;
import pt.iade.juliadisconzi.project.model.Anuncio;
import pt.iade.juliadisconzi.project.viewHolder.AnuncioViewHolder;
import pt.iade.juliadisconzi.project.R;

public class AnuncioAdapter extends RecyclerView.Adapter<AnuncioViewHolder> {

    private List<Anuncio> listaanuncios;
    private Context context;

    public AnuncioAdapter(List<Anuncio> lista){
        listaanuncios = lista;
    }

    @NonNull
    @Override
    public AnuncioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View anuncioView = inflater.inflate(R.layout.row_anuncio_list, parent, false);
        return new AnuncioViewHolder(anuncioView);
    }

    @Override
    public void onBindViewHolder(@NonNull AnuncioViewHolder holder, int position) {
        final Anuncio anuncio = listaanuncios.get(position);
        holder.bindData(anuncio);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, FormAnuncioPronto.class);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaanuncios.size();
    }
}
