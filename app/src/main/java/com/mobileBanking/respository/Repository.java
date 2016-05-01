package com.mobileBanking.respository;

import java.util.Set;

/**
 * Created by Isiphile on 2016-04-20.
 */
public interface Repository<E, ID> {

    E findById(ID id);

    E save(E entity);

    E update(E entity);

    E delete(E entity);

    Set<E> findAll();

    int deleteAll();
}