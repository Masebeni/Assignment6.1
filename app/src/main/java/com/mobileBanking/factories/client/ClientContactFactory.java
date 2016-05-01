package com.mobileBanking.factories.client;

import com.mobileBanking.domain.client.ClientContact;

/**
 * Created by Isiphile on 2016-04-20.
 */
public class ClientContactFactory {
    public static ClientContact getContact(long identity, String number, String mail) {
        return new ClientContact.Builder()
                .id(identity)
                .cellNumber(number)
                .email(mail)
                .build();
    }
}