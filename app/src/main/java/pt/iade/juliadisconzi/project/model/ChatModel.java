package pt.iade.juliadisconzi.project.model;

public class ChatModel {
    private String messageText;
    private boolean isSentByUser;

    public ChatModel(String messageText, boolean isSentByUser) {
        this.messageText = messageText;
        this.isSentByUser = isSentByUser;
    }

    public String getMessageText() {
        return messageText;
    }

    public boolean isSentByUser() {
        return isSentByUser;
    }
}
