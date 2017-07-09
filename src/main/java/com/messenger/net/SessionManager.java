package com.messenger.net;

import com.messenger.MessengerUser;
import com.messenger.messages.MessageWrapper;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by avk on 09.07.17.
 **/

public class SessionManager {

    private Set<Session> allSessions = new HashSet<>();
    private BlockingQueue<MessageWrapper> outputQueue = new LinkedBlockingQueue<>();
    private int globalCounter = 0;

    private int generateId() {
        globalCounter++;
        return globalCounter;
    }

    public SessionManager() {
        AnsweringWorker ansWorker = new AnsweringWorker(outputQueue,this);
        ConcurrentTaskExecutor.executeTask(ansWorker);
    }

    private MessengerUser authenticateUser(Socket clientSocket) {
        throw new UnsupportedOperationException();
    }

    public Session createSession(Socket clientSocket) {
        // Authenticate user somehow
        // authenticateUser(clientSocket);
        // ..

        // Plug Todo : remove : to code
        MessengerUser messengerUser = new MessengerUser("Hello","world");

        try {
            Session session = new Session(generateId(), messengerUser, clientSocket,
                    new StringProtocol(), outputQueue);
            allSessions.add(session);
            return session;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void clearInactiveSessions() {
        throw new UnsupportedOperationException();
    }

    public Session getSessionByUser(int userId) {
        for (Session session: allSessions) {

        }
        throw new NotImplementedException();
    }
}
