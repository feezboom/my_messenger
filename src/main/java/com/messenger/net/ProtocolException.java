package com.messenger.net;

/**
 * Created by avk on 03.07.17.
 **/
/**
 * Исключение, которое бросается, когда происходят ошибки кодирования/декодирования
 */

public class ProtocolException extends Exception {
    public ProtocolException(String msg) {
        super(msg);
    }

    public ProtocolException(Throwable ex) {
        super(ex);
    }
}

