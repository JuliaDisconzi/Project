package pt.iade.juliadisconzi.project.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import pt.iade.juliadisconzi.project.model.ChatModel;
import pt.iade.juliadisconzi.project.viewHolder.ChatViewHolder;
import pt.iade.juliadisconzi.project.R;

public class ChatAdapter extends RecyclerView.Adapter<ChatViewHolder> {
    private List<ChatModel> messages;

    public ChatAdapter(List<ChatModel> messages) {
        this.messages = messages;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_chat_item, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        ChatModel message = messages.get(position);
        holder.bind(message);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }


    public void updateMessages(List<ChatModel> updatedMessages) {
        messages = updatedMessages;
        notifyDataSetChanged();
    }
}
