package com.springboot.study.service.impl;

import com.springboot.study.Dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.springboot.study.entity.User;
import com.springboot.study.service.IUserService;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> findAllUser() {

        List<User> user = userDao.findAllUser();

        return user;
    }
}
