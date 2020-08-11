package com.xlj.dao;

import com.xlj.bean.FileInfo;

import java.sql.SQLException;
import java.util.List;

public interface FileInfoMapper {

    public void addFileInfo(FileInfo fileInfo) throws SQLException;

    public List<FileInfo> findFiles() throws SQLException;

    public FileInfo findFileById(Integer fileId) throws SQLException;

}
