package pt.iade.juliadisconzi.project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pt.iade.juliadisconzi.project.adapters.ConversasAdapter;
import pt.iade.juliadisconzi.project.model.Conversa;

public class FormConversas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_conversas);

        List<Conversa> listaDeConversas = new ArrayList<>();
        listaDeConversas.add(new Conversa("Olá!", "UsuárioA"));
        listaDeConversas.add(new Conversa("Oi, tudo bem?", "UsuárioB"));

        RecyclerView recyclerView = findViewById(R.id.recycler_view_conversas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ConversasAdapter conversasAdapter = new ConversasAdapter(listaDeConversas);
        recyclerView.setAdapter(conversasAdapter);
    }
}
