package com.messenger;

/**
 * Created by avk on 03.07.17.
 **/

public class MessengerUser {
    private long id;
    private String name;
    private String pass;

    public MessengerUser(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "MessengerUser{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
