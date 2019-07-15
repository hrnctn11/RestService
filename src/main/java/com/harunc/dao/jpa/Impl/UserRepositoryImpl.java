package com.harunc.dao.jpa.Impl;

import com.harunc.dao.jpa.service.UserRepositoryService;
import com.harunc.model.Users;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Harun on 15.07.2019.
 */
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepositoryService{


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Users> findAll(){
        return entityManager.createQuery("from Users",Users.class).getResultList();
    }

    @Override
     public void create(Users user) {
        entityManager.persist(user);
    }

    @Override
    public void remove(Users user) {
        entityManager.remove(user);
    }

    @Override
    public void remove(Integer id) {
        entityManager.remove(entityManager.getReference(Users.class, id));
    }

    @Override
    public void update(Users user) {
        entityManager.merge(user);
    }


}
