package com.springboot.study.Dao.impl;

import com.springboot.study.Dao.IUserDao;
import com.springboot.study.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
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
        System.out.println("-----Dao");

        List<Map<String, Object>> list = jdbc.queryForList("select * from user");

        System.out.println(list);
        for (int i=0;i<list.size();i++) {
            System.out.println("-------peer" + list.get(i));
        }

        List<User> user = new ArrayList();
        return user;
    }
}
