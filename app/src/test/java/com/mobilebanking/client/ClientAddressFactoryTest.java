package com.mobilebanking.client;

import com.mobileBanking.domain.client.ClientAddress;
import com.mobileBanking.domain.client.ClientContact;
import com.mobileBanking.factories.client.ClientAddressFactory;
import com.mobileBanking.factories.client.ClientContactFactory;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by Isiphile on 2016-04-20.
 */
public class ClientAddressFactoryTest {
    @Test
    public void testCreate() throws Exception {
        ClientAddress clientAddress = ClientAddressFactory.getAddress(101, "Dorset", "Woodstock", "7989");
        Assert.assertEquals(clientAddress.getTown(),"Woodstock");
    }

    @Test
    public void testUpdate() throws Exception {
        ClientAddress clientAddress = ClientAddressFactory.getAddress(101, "Long", "Cape Town", "8000");
        ClientAddress newClientAddress= new ClientAddress
                .Builder()
                .copy(clientAddress)
                .town("Cape Town")
                .build();
        Assert.assertEquals(newClientAddress.getTown(),"Cape Town");

    }
}
