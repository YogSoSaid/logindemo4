package com.example.springbootexample.repository;

import com.example.springbootexample.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Long> {
    User findByUname(String name);
    User findByUnameAndPassword(String uname, String password);
    List<User> findAllByUid(Long uid);

    List<User> findAll();
}
