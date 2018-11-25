package com.springboot.study.Dao.impl;

import com.springboot.study.Dao.IUserDao;
import com.springboot.study.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class UserDao implements IUserDao {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<User> findAllUser(){

        RowMapper<User> mapper = new BeanPropertyRowMapper<>(User.class);


        return jdbc.query("select * from user",mapper);
    }
}
