package pt.iade.juliadisconzi.project.viewHolder;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import pt.iade.juliadisconzi.project.model.ChatModel;
import pt.iade.juliadisconzi.project.R;

public class ChatViewHolder extends RecyclerView.ViewHolder {
    private TextView messageText;


    public ChatViewHolder(@NonNull View itemView) {
        super(itemView);
        messageText = itemView.findViewById(R.id.message_text);

    }

    public void bind(ChatModel chatModel) {
        messageText.setText(chatModel.getMessageText());
    }
}
