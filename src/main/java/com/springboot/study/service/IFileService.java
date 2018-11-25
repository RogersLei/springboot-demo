package com.springboot.study.service;

import com.springboot.study.entity.File;

import java.util.List;

public interface IFileService {
    int saveFileName(String filename);

    List<File> findAllFile();
}
