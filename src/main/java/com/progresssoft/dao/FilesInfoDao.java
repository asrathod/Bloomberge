package com.progresssoft.dao;

import java.util.List;

import com.progresssoft.bean.FileInfoBean;


public interface FilesInfoDao {

	public long createNewFile(String fileName);
	public FileInfoBean getFileByName(String fileName);
	public List<FileInfoBean> getAllFiles();
}
