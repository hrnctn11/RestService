package com.harunc.dao.jpa.service;

import com.harunc.model.Users;

import java.util.List;

/**
 * Created by Harun on 15.07.2019.
 */
public interface UserRepositoryService {
    List<Users> findAll();

    void create(Users user);

    void remove(Users user);

    void remove(Integer id);

    void update(Users user);
}
