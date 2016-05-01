package com.mobileBanking.repository.account;

import android.test.AndroidTestCase;
//import junit.framework.Assert;

import com.mobileBanking.domain.account.Credit;
import com.mobileBanking.respository.account.CreditRepository;
import com.mobileBanking.respository.account.Impl.CreditRepositoryImpl;


import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Isiphile on 2016-04-20.
 */
public class CreditRepositoryTest extends AndroidTestCase {
    private static final String TAG="CREDIT TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        CreditRepository repo = new CreditRepositoryImpl(this.getContext()) {
        };
        // CREATE
        Credit createEntity = new Credit.Builder()
                .name("credit")
                .balance(5000)
                .dailyLimit(2000)
                .creditLimit(10000)
                .build();
        Credit insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG + " CREATE", insertedEntity);

        //READ ALL
        Set<Credit> credits = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",credits.size()>0);

        //READ ENTITY
        Credit entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);

        //UPDATE ENTITY
        Credit updateEntity = new Credit.Builder()
                .name("credit")
                .balance(2000)
                .dailyLimit(100)
                .creditLimit(5000)
                .build();
        repo.update(updateEntity);
        Credit newCredit = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", 1,2000, newCredit.getBalance());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Credit deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }

}
