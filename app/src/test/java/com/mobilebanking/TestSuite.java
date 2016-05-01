package com.mobilebanking;

import com.mobileBanking.factories.client.ClientAddressFactory;
import com.mobileBanking.factories.client.ClientContactFactory;
import com.mobileBanking.factories.client.ClientFactory;
import com.mobilebanking.account.ChequeFactoryTest;
import com.mobilebanking.account.CreditFactoryTest;
import com.mobilebanking.account.SavingsFactoryTest;
import com.mobilebanking.bank.BankContactDetailsFactoryTest;
import com.mobilebanking.bank.BankFactoryTest;
import com.mobilebanking.client.ClientAddressFactoryTest;
import com.mobilebanking.client.ClientContactFactoryTest;
import com.mobilebanking.client.ClientFactoryTest;
import com.mobilebanking.transaction.AirTimeFactoryTest;
import com.mobilebanking.transaction.PaymentFactoryTest;
import com.mobilebanking.transaction.WithdrawFactoryTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
// Runs all unit tests.
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ClientAddressFactoryTest.class,
        ClientContactFactoryTest.class,
        ClientFactoryTest.class,
        ChequeFactoryTest.class,
        CreditFactoryTest.class,
        SavingsFactoryTest.class,
        BankFactoryTest.class,
        BankContactDetailsFactoryTest.class,
        AirTimeFactoryTest.class,
        PaymentFactoryTest.class,
        WithdrawFactoryTest.class,})
public class TestSuite {}