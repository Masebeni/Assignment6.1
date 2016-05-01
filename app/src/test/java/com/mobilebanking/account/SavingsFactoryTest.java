package com.mobilebanking.account;

import com.mobileBanking.domain.account.Cheque;
import com.mobileBanking.domain.account.Savings;
import com.mobileBanking.factories.account.ChequeFactory;
import com.mobileBanking.factories.account.SavingsFactory;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by Isiphile on 2016-04-20.
 */
public class SavingsFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Savings savings = SavingsFactory.getSavings(100, "savings", 5000);
        Assert.assertEquals(savings.getName(),"savings");
    }

    @Test
    public void testUpdate() throws Exception {
        Savings savings = SavingsFactory.getSavings(101, "current", 200);

        Savings newSavings = new Savings
                .Builder()
                .balance(800)
                .copy(savings)
                .build();
        Assert.assertEquals(newSavings.getBalance(),1,200);
    }
}
