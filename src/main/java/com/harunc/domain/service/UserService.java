package com.harunc.domain.service;

import com.harunc.model.Users;

import java.util.List;

/**
 * Created by Harun on 15.07.2019.
 */
public interface UserService {

    List<Users> findAll();

    void create(Users user);

    void update(Users user);

    void remove(Users user);

    void remove(Integer id);
}
