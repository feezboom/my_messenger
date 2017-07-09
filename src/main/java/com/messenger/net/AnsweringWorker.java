package com.messenger.net;

import com.messenger.messages.Message;
import com.messenger.messages.MessageWrapper;

import java.util.concurrent.BlockingQueue;

/**
 * Created by avk on 09.07.17.
 **/

public class AnsweringWorker implements Runnable {

    private final SessionManager sessionManager;
    private final BlockingQueue<MessageWrapper> outputQueue;

    public AnsweringWorker(BlockingQueue<MessageWrapper> outputQueue, SessionManager sessionManager) {
        this.sessionManager = sessionManager;
        this.outputQueue = outputQueue;
    }

    @Override
    public void run() {

        while (true) {
            MessageWrapper wrapper = this.outputQueue.poll();
            Message msg = wrapper.getMessage();
            Session ssnFrom = wrapper.getSession();


        }
    }
}
