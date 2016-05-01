package com.mobilebanking.transaction;

import com.mobileBanking.domain.bank.Bank;
import com.mobileBanking.domain.transaction.AirTime;
import com.mobileBanking.factories.bank.BankFactory;
import com.mobileBanking.factories.transaction.AirTimeFactory;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by Isiphile on 2016-04-20.
 */
public class AirTimeFactoryTest {
    @Test
    public void testCreate() throws Exception {
        AirTime airTime = AirTimeFactory.getAirTime((long)101, "savings", "mtn", 30);
        Assert.assertEquals(airTime.getAccount(),"savings");
    }

    @Test
    public void testUpdate() throws Exception {
        AirTime airTime = AirTimeFactory.getAirTime((long) 101, "credit", "cellc", 60);
        AirTime newAirTime = new AirTime
                .Builder()
                .copy(airTime)
                .network("vodacom")
                .build();
        Assert.assertEquals(newAirTime.getNetwork(),"vodacom");

    }
}
