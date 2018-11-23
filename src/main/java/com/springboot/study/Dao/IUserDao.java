package com.springboot.study.Dao;

import com.springboot.study.entity.User;

import java.util.List;

public interface IUserDao {
    List<User> findAllUser();
}
