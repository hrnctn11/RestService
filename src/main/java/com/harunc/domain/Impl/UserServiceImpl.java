package com.harunc.domain.Impl;

import com.harunc.dao.jpa.service.UserRepositoryService;
import com.harunc.domain.service.UserService;
import com.harunc.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Harun on 15.07.2019.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositoryService userRepositoryService;

    @Override
    public List<Users> findAll() {
        return userRepositoryService.findAll();
    }

    @Override
    public void create(Users user) {
          userRepositoryService.create(user);
    }

    @Override
    public void update(Users user) {
        userRepositoryService.update(user);
    }


    @Override
    public void remove(Users user) {
        userRepositoryService.remove(user.getId());
    }

    @Override
    public void remove(Integer id) {
        userRepositoryService.remove(id);
    }
}
