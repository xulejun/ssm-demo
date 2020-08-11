package com.xlj.service.impl;

import com.xlj.bean.FileInfo;
import com.xlj.dao.FileInfoMapper;
import com.xlj.service.FileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author XuLeJun
 * @Date 2020/6/24 14:47
 */

@Service
public class FileInfoServiceImpl implements FileInfoService {
    @Autowired
    FileInfoMapper fileInfoMapper;

    @Override
    public void addFileInfo(FileInfo fileInfo) throws SQLException {
        fileInfoMapper.addFileInfo(fileInfo);
    }

    @Override
    public FileInfo findFileById(int id) throws SQLException {
        return fileInfoMapper.findFileById(id);
    }

    @Override
    public List<FileInfo> list() throws SQLException {
        return fileInfoMapper.findFiles();
    }
}
