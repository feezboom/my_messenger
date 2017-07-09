package com.messenger.net;


import com.messenger.messages.Message;
import com.messenger.messages.MessageType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


class Worker implements Runnable {

    private String message;
    private PrintWriter out;
    private BufferedReader in;


    public Worker(Socket clientSocket) throws IOException {
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }


    public void run() {
        while (true) {
            try {
                // Read message from in.
                String encodedMessage = in.readLine();

                // Parse received message.
                Protocol protocol = new StringProtocol();
                Message message = protocol.decode(encodedMessage.getBytes());

                // If other user needed, put task in the global queue.
                MessageType type = message.getType();
                switch (type) {
                    case MSG_TEXT:

                }

                // else answer this user.
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                System.out.println("Hello, world!");
            }
            break;
        }
    }

    private void ProcessMessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}