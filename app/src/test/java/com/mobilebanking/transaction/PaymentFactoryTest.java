package com.mobilebanking.transaction;

import com.mobileBanking.domain.client.ClientContact;
import com.mobileBanking.domain.transaction.Payment;
import com.mobileBanking.factories.client.ClientContactFactory;
import com.mobileBanking.factories.transaction.PaymentFactory;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by Isiphile on 2016-04-20.
 */
public class PaymentFactoryTest {
    @Test
    public void testCreate() throws Exception {
        Payment payment = PaymentFactory.getPayment(101, "savings", "credit", 200);
        Assert.assertEquals(payment.getToAccount(),"credit");
    }

    @Test public void testUpdate() throws Exception {
    Payment payment = PaymentFactory.getPayment(101, "savings", "credit", 200);
        Payment newPayment = new Payment
            .Builder()
            .copy(payment)
            .fromAccount("savings")
            .build();
    Assert.assertEquals(newPayment.getFromAccount(),"savings");
    }
}
