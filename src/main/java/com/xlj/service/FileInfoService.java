package com.xlj.service;

import com.xlj.bean.FileInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author XuLeJun
 * @Date 2020/6/24 14:43
 */

public interface FileInfoService {

    void addFileInfo(FileInfo fileInfo) throws SQLException;

    FileInfo findFileById(int id) throws SQLException;

    List<FileInfo> list() throws SQLException;

}
