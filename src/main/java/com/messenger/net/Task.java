package com.messenger.net;

import com.messenger.messages.Message;

/**
 * Created by avk on 09.07.17.
 **/

public class Task {

    public Task(int receiverId) {
        this.receiverId = receiverId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    private int receiverId;

    Message message;
}
