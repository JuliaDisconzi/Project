package pt.iade.juliadisconzi.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import pt.iade.juliadisconzi.project.adapters.ChatAdapter;
import pt.iade.juliadisconzi.project.model.ChatModel;

public class FormChat extends AppCompatActivity {

    private Button btn_chat;
    private EditText message_edittext;
    private RecyclerView message_list;
    private ChatAdapter chatAdapter;
    private List<ChatModel> listaDeMensagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_chat);

        btn_chat = findViewById(R.id.btn_chat);
        message_edittext = findViewById(R.id.message_edittext);
        message_list = findViewById(R.id.message_list);

        message_edittext.requestFocus();


        listaDeMensagens = new ArrayList<>();


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        message_list.setLayoutManager(layoutManager);


        chatAdapter = new ChatAdapter(listaDeMensagens);
        message_list.setAdapter(chatAdapter);

        btn_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = message_edittext.getText().toString();
                if (!message.isEmpty()) {
                    ChatModel newMessage = new ChatModel(message, true);
                    listaDeMensagens.add(newMessage);

                    Log.d("FormChat", "Novo item adicionado à lista: " + message);


                    chatAdapter.notifyItemInserted(listaDeMensagens.size() - 1);


                    message_edittext.setText("");



                }
            }
        });

    }
}
