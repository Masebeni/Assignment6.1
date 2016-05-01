package com.mobileBanking.repository.account;

import android.test.AndroidTestCase;


import junit.framework.Assert;
import java.util.Set;

import com.mobileBanking.domain.account.Cheque;
import com.mobileBanking.respository.account.ChequeRepository;
import com.mobileBanking.respository.account.Impl.ChequeRepositoryImpl;

/**
 * Created by Isiphile on 2016-04-20.
 */
public class ChequeRepositoryTest extends AndroidTestCase {
    private static final String TAG="CHEQUE TEST";
    private Long id;

    public void testCreateReadUpdateDelete() throws Exception {
        ChequeRepository repo = new ChequeRepositoryImpl(this.getContext()) {
        };
        // CREATE
        Cheque createEntity = new Cheque.Builder()
                .name("cheque")
                .balance(5000)
                .dailyLimit(2500)
                .build();
        Cheque insertedEntity = repo.save(createEntity);
        id=insertedEntity.getId();
        Assert.assertNotNull(TAG+" CREATE",insertedEntity);

        //READ ALL
        Set<Cheque> cheques = repo.findAll();
        Assert.assertTrue(TAG+" READ ALL",cheques.size()>0);

        //READ ENTITY
        Cheque entity = repo.findById(id);
        Assert.assertNotNull(TAG+" READ ENTITY",entity);



        //UPDATE ENTITY
        Cheque updateEntity = new Cheque.Builder()
                .name("cheque")
                .balance(10000)
                .dailyLimit(5000)
                .build();
        repo.update(updateEntity);
        Cheque newCheque = repo.findById(id);
        Assert.assertEquals(TAG + " UPDATE ENTITY", "cheque", newCheque.getName());

        // DELETE ENTITY
        repo.delete(updateEntity);
        Cheque deletedEntity = repo.findById(id);
        Assert.assertNull(TAG+" DELETE",deletedEntity);

    }

}
