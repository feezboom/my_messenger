package com.messenger.messages;

/**
 * Created by avk on 03.07.17.
 **/

public class LoginMessage extends Message {
    private String name;
    private String pass;

    public LoginMessage(String name, String pass) {
        type = MessageType.MSG_LOGIN;
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "LoginMessage{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
