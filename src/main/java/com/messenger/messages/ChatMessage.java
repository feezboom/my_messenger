package com.messenger.messages;


/**
 * Text message for all in the chat.
 * 0 - message for all.
 */
public class ChatMessage extends TextMessage {
    private Long chatId;

    public ChatMessage(String msgText, Long chatId) {
        this.chatId = chatId;
        this.setText(msgText);
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }
}
