package com.messenger.net;

/**
 * Created by avk on 03.07.17.
 **/

import com.messenger.messages.Message;
import com.messenger.messages.MessageType;
import com.messenger.messages.TextMessage;


/**
 * Простейший протокол передачи данных
 */
public class StringProtocol implements Protocol {

//    static Logger log = LoggerFactory.getLogger(StringProtocol.class);

    public static final String DELIMITER = ";";

    @Override
    public Message decode(byte[] bytes) throws ProtocolException {
        String str = new String(bytes);
//        log.info("decoded: {}", str);
        String[] tokens = str.split(DELIMITER);
        MessageType type = MessageType.valueOf(tokens[0]);
        switch (type) {
            case MSG_TEXT:
                TextMessage textMsg = new TextMessage();
                textMsg.setSenderId(parseLong(tokens[1]));
                textMsg.setText(tokens[2]);
                textMsg.setType(type);
                return textMsg;
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
            case MSG_TEXT:
                TextMessage sendMessage = (TextMessage) msg;
                builder.append(String.valueOf(sendMessage.getSenderId())).append(DELIMITER);
                builder.append(sendMessage.getText()).append(DELIMITER);
                break;
            default:
                throw new ProtocolException("Invalid type: " + type);


        }
//        log.info("encoded: {}", builder.toString());
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