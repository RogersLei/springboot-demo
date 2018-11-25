package com.springboot.study.Dao;

import com.springboot.study.entity.File;

import java.util.List;

public interface IFileDao {
    int saveFile(String filename);

    List<File> findAllFile();
}
