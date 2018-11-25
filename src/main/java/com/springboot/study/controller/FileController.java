package com.springboot.study.controller;


import com.springboot.study.service.IFileService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.Map;

@Controller
public class FileController {

    private String folder = "/Users/rogers/LearnSpace/study/src/main/resources/static";

    @Autowired
    private IFileService fileService;


    @RequestMapping("/upload")
    public String upload(@RequestParam("fileName") MultipartFile file, Map<String,String> map) throws IOException {

        System.out.println("origin file name=" + file.getOriginalFilename());
        System.out.println("file size=" + file.getSize());

        String filename = new Date().getTime() + ".txt";

        File localFile = new File(folder,  filename);

        // 把传入的文件写到本地文件
        file.transferTo(localFile);

        // 存入数据库
        int result = fileService.saveFileName(filename);
        System.out.println("=============" + result);

        map.put("result", result == 1 ? "上传成功" : "上传失败");

        System.out.println(localFile.getAbsolutePath());

        return "user/adduser";
    }

    @RequestMapping("/download")
    public String download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("download");

        try (
                InputStream inputStream = new FileInputStream(new File(folder, "test.txt"));
                OutputStream outputStream = response.getOutputStream()
        ) {
            response.setContentType("application/x-download");
            String fileName = "test.txt";
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);   // 设置文件名


            //把输入流copy到输出流
            IOUtils.copy(inputStream, outputStream);

            outputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "user/adduser";
    }
}
