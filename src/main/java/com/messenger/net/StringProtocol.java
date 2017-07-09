package com.messenger.net;

/**
 * Created by avk on 03.07.17.
 **/

import com.messenger.messages.ChatMessage;
import com.messenger.messages.Message;
import com.messenger.messages.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Простейший протокол передачи данных
 */
public class StringProtocol implements Protocol {

    static Logger log = LoggerFactory.getLogger(StringProtocol.class);

    public static final String DELIMITER = ";";

    @Override
    public Message decode(byte[] bytes) throws ProtocolException {
        String str = new String(bytes);
//        log.info("decoded: {}", str);
        String[] tokens = str.split(DELIMITER);
        MessageType type = MessageType.valueOf(tokens[0]);
        switch (type) {
            case MSG_TEXT_CHAT:
                ChatMessage chatMsg = new ChatMessage("", 0L);
                chatMsg.setSenderId(parseLong(tokens[1]));
                chatMsg.setText(tokens[2]);
                chatMsg.setType(type);
                chatMsg.setChatId(parseLong(tokens[3]));

                return chatMsg;
            default:
                throw new ProtocolException("Invalid type: " + type);
        }
    }


    @Override
    public byte[] encode(Message msg) throws ProtocolException {
        StringBuilder builder = new StringBuilder();
        MessageType type = msg.getType();
        builder.append(type).append(DELIMITER);
        switch (type) {
            case MSG_TEXT_CHAT:
                ChatMessage sendMessage = (ChatMessage) msg;
                builder.append(String.valueOf(sendMessage.getSenderId())).append(DELIMITER);
                builder.append(sendMessage.getText()).append(DELIMITER);
                builder.append(sendMessage.getChatId()).append(DELIMITER);
                break;
            default:
                throw new ProtocolException("Invalid type: " + type);


        }
        log.info("encoded: {}", builder.toString());
        return builder.toString().getBytes();
    }

    private Long parseLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            // who care
        }
        return null;
    }
}
