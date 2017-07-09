package com.messenger.store;

import com.messenger.MessengerUser;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by avk on 09.07.17.
 **/

public class UsersManager implements UserStore {

    public MessengerUser addUser(MessengerUser messengerUser) throws NotImplementedException {
        throw new NotImplementedException();
    }

    public MessengerUser updateUser(MessengerUser messengerUser) throws NotImplementedException {
        throw new NotImplementedException();
    }

    public MessengerUser getUser(String login, String pass) throws NotImplementedException {
        return new MessengerUser("Mike Wasovsky", "helloMike");
    }

    public MessengerUser getUserById(Long id) throws NotImplementedException {
        throw new NotImplementedException();
    }

}
