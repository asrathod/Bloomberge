package com.progresssoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.progresssoft.bean.FileInfoBean;
import com.progresssoft.dao.FilesInfoDao;
import com.progresssoft.service.FileInfoService;

@Service
@Transactional
public class FileInfoServiceImpl implements FileInfoService{

	@Autowired
    private FilesInfoDao filesInfoDao; 
	
	@Override
	public long createNewFile(String fileName) {
		return filesInfoDao.createNewFile(fileName);
	}

	@Override
	public FileInfoBean getFileByName(String fileName) {
		return filesInfoDao.getFileByName(fileName);
	}

	@Override
	public List<FileInfoBean> getAllFiles() {
		
		return filesInfoDao.getAllFiles();
	}

}
