package com.messenger.net;

/**
 * Created by avk on 03.07.17.
 **/

import com.messenger.MessengerUser;
import com.messenger.messages.ChatMessage;
import com.messenger.messages.Message;

import com.messenger.messages.MessageWrapper;
import com.messenger.messages.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;


/**
 * Сессия связывает бизнес-логику и сетевую часть.
 * Бизнес логика представлена объектом юзера - владельца сессии.
 * Сетевая часть привязывает нас к определнному соединению по сети (от клиента)
 */
public class Session implements Runnable {
    private int id;
    static Logger log = LoggerFactory.getLogger(Session.class);

    private BlockingQueue<MessageWrapper> outputQueue;

    private MessengerUser user;
    private Socket socket;
    private Protocol protocol;

    private InputStream in;
    private OutputStream out;

    private volatile boolean isActive;
    private byte[] buffer = new byte[1024 * 16]; // 16 kb

    public Session(int id, MessengerUser user, Socket socket, Protocol protocol,
                   BlockingQueue<MessageWrapper> outputQueue)
            throws IOException {
        this.id = id;
        this.user = user;
        this.socket = socket;
        this.protocol = protocol;
        this.outputQueue = outputQueue;

        in = socket.getInputStream();
        out = socket.getOutputStream();
    }

    public void send(Message msg) throws ProtocolException, IOException {
        byte encoded[] = protocol.encode(msg);
        synchronized (this) {
            out.write(encoded);
        }
    }

    public void onMessage(Message msg) {
        // TODO: Process incoming message somehow
        // ...
        TextMessage message = (TextMessage)msg;
        String sentText = message.getText();

        // For the first time send this message to all.
        ChatMessage outputMsg = new ChatMessage(sentText, 0L);
        MessageWrapper outputTask = new MessageWrapper(outputMsg, this);
        synchronized (this) {
            outputQueue.add(outputTask);
        }
    }

    public void close() throws IOException {
        // TODO: закрыть in/out каналы и сокет. Освободить другие ресурсы, если необходимо.
        in.close();
        out.close();
    }

    @Override
    public void run() {
        while (isActive) {
            try {

                int readBytes;
                synchronized (this) {
                    readBytes = in.read(buffer);
                }
                final byte[] slice = Arrays.copyOfRange(buffer, 0, readBytes);
                Message message = protocol.decode(slice);
                onMessage(message);

            } catch (Exception e) {
                isActive = false;
                log.error("Session failed: ", e);
            }
        }
    }
}
