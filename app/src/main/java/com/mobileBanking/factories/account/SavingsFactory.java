package com.mobileBanking.factories.account;

import com.mobileBanking.domain.account.Savings;

/**
 * Created by Isiphile on 2016-04-20.
 */
public class SavingsFactory {
    public static Savings getSavings(long identity, String nam, float bal){
        return new Savings.Builder()
                .id(identity)
                .name(nam)
                .balance(bal)
                .build();
    }
}
