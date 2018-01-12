package com.progresssoft.service;

import java.util.List;

import com.progresssoft.bean.FileInfoBean;

public interface FileInfoService {
	public long createNewFile(String fileName);
	public FileInfoBean getFileByName(String fileName);
	public List<FileInfoBean> getAllFiles();
}
