package com.messenger.store;

import com.messenger.MessengerUser;

/**
 * Created by avk on 03.07.17.
 **/

public interface UserStore {
    /**
     * Добавить пользователя в хранилище
     * Вернуть его же
     */
    MessengerUser addUser(MessengerUser user);

    /**
     * Обновить информацию о пользователе
     */
    MessengerUser updateUser(MessengerUser messengerUser);

    /**
     *
     * Получить пользователя по логину/паролю
     * return null if user not found
     */
    MessengerUser getUser(String login, String pass);

    /**
     *
     * Получить пользователя по id, например запрос информации/профиля
     * return null if user not found
     */
    MessengerUser getUserById(Long id);
}
