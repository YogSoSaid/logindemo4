package com.example.springbootexample.service;

import java.util.List;

import com.example.springbootexample.domain.User;

public interface UserService {
    User loginService(String uname, String password);

    User registService(User user);

    List<User> findService(Long uid);

    List<User> findUserAll();

    User deleteOneUserService();
}
