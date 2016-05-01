package com.mobileBanking.repository.client;

import android.test.AndroidTestCase;

import com.mobileBanking.domain.bank.Bank;
import com.mobileBanking.respository.bank.BankRepository;
import com.mobileBanking.respository.bank.Impl.BankRepositoryImpl;

import junit.framework.Assert;

import java.util.Set;

/**
 * Created by Isiphile on 2016-04-20.
 */
public class ClientRepositoryTest extends AndroidTestCase {
    private static final String TAG="BANK TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        BankRepository repo = new BankRepositoryImpl(this.getContext()) {
        };
        // CREATE
        Bank createEntity = new Bank.Builder()
                .name("absa")
                .branch("cape town")
                .build();
        Bank insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Bank> banks = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",banks.size()>0);

        //READ ENTITY
        Bank entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        Bank updateEntity = new Bank.Builder()
                .name("nedbank")
                .branch("durban")
                .build();
        repo.update(updateEntity);
        Bank newBank = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "nedbank", newBank.getName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Bank deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }

}
