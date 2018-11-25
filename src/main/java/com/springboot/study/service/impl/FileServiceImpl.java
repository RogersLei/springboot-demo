package com.springboot.study.service.impl;

import com.springboot.study.Dao.IFileDao;
import com.springboot.study.entity.File;
import com.springboot.study.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FileServiceImpl implements IFileService {

    @Autowired
    private IFileDao fileDao;

    @Override
    public int saveFileName(String filename) {
        System.out.println("save file service" + filename);

        return fileDao.saveFile(filename);
    }

    @Override
    public List<File> findAllFile() {
        System.out.println("find file service");

        return fileDao.findAllFile();
    }
}
