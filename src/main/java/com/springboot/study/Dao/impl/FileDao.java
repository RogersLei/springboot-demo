package com.springboot.study.Dao.impl;


import com.springboot.study.Dao.IFileDao;
import com.springboot.study.entity.File;
import com.springboot.study.entity.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FileDao implements IFileDao {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public int saveFile(String filename) {
        System.out.println("file dao service"+ filename);

        return jdbc.update("insert into file (file_name) values (?)", filename);
    }

    @Override
    public List<File> findAllFile() {
        System.out.println("find file dao service");

        RowMapper<File> mapper = new BeanPropertyRowMapper<>(File.class);

        List<File> lists = jdbc.query("select * from file", mapper);

        System.out.println(lists);

        List<File> list = new ArrayList();


        return list;
    }
}
