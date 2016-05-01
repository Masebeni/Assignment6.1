package com.mobileBanking.factories.transaction;

import com.mobileBanking.domain.transaction.AirTime;

/**
 * Created by Isiphile on 2016-04-20.
 */
public class AirTimeFactory {
    public static AirTime getAirTime(Long identity, String acc, String net, float money){
        return new AirTime.Builder()
                .id(identity)
                .account(acc)
                .network(net)
                .amount(money)
                .build();
    }
}
