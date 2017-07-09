package com.messenger.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class MessengerServer
{
    private int port;
    private ServerSocket serverSocket;
    private SessionManager sessionManager;

    public MessengerServer(int port) {
        this.port = port;
    }

    public void init() {
        try {
            this.serverSocket = new ServerSocket(port);
            sessionManager = new SessionManager();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            while (true) {
                acceptConnection();
             }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void acceptConnection() throws IOException {
        Socket clientSocket = serverSocket.accept();
        Session sessionTask = sessionManager.createSession(clientSocket);
        ConcurrentTaskExecutor.executeTask(sessionTask);
    }

    public static void main(String[] args) throws Exception
    {
        MessengerServer server = new MessengerServer(8080);
        server.init();
        server.start();
    }
}
