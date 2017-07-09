package com.messenger.messages;

import java.io.Serializable;

/**
 * Created by avk on 03.07.17.
 **/


public abstract class Message implements Serializable {

    protected Long id;
    protected Long senderId;
    protected MessageType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }
}