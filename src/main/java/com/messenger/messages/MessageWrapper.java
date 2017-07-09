package com.messenger.messages;

import com.messenger.net.Session;

/**
 * Created by avk on 09.07.17.
 **/
public class MessageWrapper {

    private Message message;
    private Session session;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public MessageWrapper(Message message, Session session) {

        this.message = message;
        this.session = session;
    }
}
