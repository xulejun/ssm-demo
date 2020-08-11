package com.xlj.controller;

import com.xlj.bean.FileInfo;
import com.xlj.bean.UploadImage;
import com.xlj.service.FileInfoService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.util.*;

/**
 * @Author XuLeJun
 * @Date 2020/6/28 9:23
 */

@Controller
public class UploadController {

    @Autowired
    FileInfoService fileInfoService;

    // 访问跳转到WEB-INF/js/fileuser.jsp页面
    @RequestMapping("fileuser")
    public String fileuser() {
        return "fileuser";
    }

    // 访问跳转到WEB-INF/js/upload.jsp页面
    @RequestMapping("upload")
    public String upload() {
        return "upload";
    }

    // 图片上传
    @RequestMapping("uploadImage")
    public void uploadImage(HttpServletResponse httpServletResponse, UploadImage file) throws IOException, SQLException {
        // 给上传的图片随机取名
        String random = RandomStringUtils.randomAlphanumeric(10);
        String fileName = random + ".jpg";

        // 文件上传路径
        String filePath = "G:\\Idea-workspace\\ssm-demo\\src\\main\\webapp\\image";
        // 文件上传相对服务器路径target/ssm-demo/image
        // File newFile = new File(httpServletRequest.getServletContext().getRealPath("/image"), newName);

        File newFile = new File(filePath, fileName);
        newFile.getParentFile().mkdir();

        // 向url地址存储文件
        String fileUrl = filePath + "\\" + fileName;
//        FileUtil.writeFileToUrl(file.getImage(),fileUrl);

        // 保存文件信息
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileName(fileName);
        fileInfo.setFileUrl(fileUrl);
        // 写入数据库
        fileInfoService.addFileInfo(fileInfo);

        // 文件上传
        file.getImage().transferTo(newFile);

        // 文件上传成功，页面弹窗提示
//        if (newFile.exists()) {
//            httpServletResponse.setContentType("text/html; charset=UTF-8");//注意text/html，和application/html
//            httpServletResponse.getWriter().print("<html><body><script type='text/javascript'>alert('文件已上传');</script></body></html>");
//            httpServletResponse.getWriter().close();
//        }
        httpServletResponse.sendRedirect("fileuser");

    }

    @RequestMapping("listfile")
    public ModelAndView listfile() throws SQLException {
        ModelAndView modelAndView = new ModelAndView();
        List<FileInfo> list = fileInfoService.list();

        // 传参到页面上
        modelAndView.addObject("list", list);
        // 放入jsp路径
        modelAndView.setViewName("listfile");
        return modelAndView;

    }

    // 访问跳转到WEB-INF/js/download.jsp页面
//    @RequestMapping("download")
//    public String download() {
//        return "download";
//    }

    //图片下载
    @RequestMapping("download")
    public ResponseEntity<byte[]> download(Integer fileId) throws IOException, SQLException {
        FileInfo fileInfo = fileInfoService.findFileById(fileId);
        String fileName = fileInfo.getFileName();
        String fileUrl = fileInfo.getFileUrl();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        ResponseEntity<byte[]> entity =
                new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(fileUrl)), headers, HttpStatus.CREATED);
        if (entity == null){
            return null;
        }else {
            return entity;
        }
    }
}

