package com.mobileBanking.factories.transaction;


import com.mobileBanking.domain.transaction.Withdraw;

/**
 * Created by Isiphile on 2016-04-20.
 */
public class WithdrawFactory{
    public static Withdraw getWithdraw(long identity, String from, float money){
        return  new Withdraw.Builder()
                .id(identity)
                .fromAccount(from)
                .amount(money)
                .build();
    }
}
