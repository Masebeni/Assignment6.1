package com.mobileBanking.repository.account;

import android.test.AndroidTestCase;

import com.mobileBanking.domain.account.Savings;
import com.mobileBanking.respository.account.Impl.SavingsRepositoryImpl;
import com.mobileBanking.respository.account.SavingsRepository;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Isiphile on 2016-04-20.
 */
public class SavingsRepositoryTest extends AndroidTestCase {
    private static final String TAG="SAVINGS TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        SavingsRepository repo = new SavingsRepositoryImpl(this.getContext()) {
        };
        // CREATE
        Savings createEntity = new Savings.Builder()
                .name("savings")
                .balance(90000)
                .build();
        Savings insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Savings> savings = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",savings.size()>0);

        //READ ENTITY
        Savings entity = repo.findById(id);
        Assert.assertNotNull(TAG + " READ ENTITY", entity);



        //UPDATE ENTITY
        Savings updateEntity = new Savings.Builder()
                .name("savings")
                .balance(140000)
                .build();
        repo.update(updateEntity);
        Savings newSavings = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", 1,140000, newSavings.getBalance());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Savings deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }

}
