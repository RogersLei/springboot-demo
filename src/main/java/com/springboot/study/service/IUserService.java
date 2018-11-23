package com.springboot.study.service;

import com.springboot.study.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAllUser();
}
