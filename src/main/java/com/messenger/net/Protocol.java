package com.messenger.net;

import com.messenger.messages.Message;

/**
 * Created by avk on 03.07.17.
 **/
public interface Protocol {

    Message decode(byte[] bytes) throws ProtocolException;

    byte[] encode(Message msg) throws ProtocolException;

}
