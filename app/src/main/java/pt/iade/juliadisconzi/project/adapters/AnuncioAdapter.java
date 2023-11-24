package pt.iade.juliadisconzi.project.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import pt.iade.juliadisconzi.project.R;
import pt.iade.juliadisconzi.project.models.Anuncio;

public class AnuncioAdapter extends RecyclerView.Adapter<AnuncioAdapter.AnuncioViewHolder> {

    private List<Anuncio> listaDeAnuncios;

    public AnuncioAdapter(List<Anuncio> listaDeAnuncios) {
        this.listaDeAnuncios = listaDeAnuncios;
    }

    @Override
    public AnuncioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_lista_anuncio, parent, false);
        return new AnuncioViewHolder(itemView);
    }

    public void onBindViewHolder(@NonNull AnuncioViewHolder holder, int position) {
        Anuncio anuncio = listaDeAnuncios.get(position);
        holder.bind(anuncio);
    }

    @Override
    public int getItemCount() {
        return listaDeAnuncios.size();
    }

    public static class AnuncioViewHolder extends RecyclerView.ViewHolder {

        private final TextView textViewTitulo;
        private final TextView textViewDescricao;

        public AnuncioViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitulo = itemView.findViewById(R.id.textView);
            textViewDescricao = itemView.findViewById(R.id.editTextNumber);
        }

        public void bind(Anuncio anuncio) {
            textViewTitulo.setText(anuncio.getTitulo());
            textViewDescricao.setText(anuncio.getDescricao());
        }
    }
}
