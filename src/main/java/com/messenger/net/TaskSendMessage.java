package com.messenger.net;

import com.messenger.messages.Message;

/**
 * Created by avk on 09.07.17.
 **/

public class TaskSendMessage implements Runnable {

    private final Message message;

    public TaskSendMessage(Message message) {
        this.message = message;
    }

    @Override
    public void run() {

    }


}
