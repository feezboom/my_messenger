package com.messenger.messages;

/**
 * Created by avk on 09.07.17.
 **/
public class PersonalMessage extends TextMessage {

    public PersonalMessage(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Long getReceiverId() {

        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    private Long receiverId;
}
