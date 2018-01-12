package com.progresssoft.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.progresssoft.bean.FileInfoBean;
import com.progresssoft.bean.ValidDealsBean;
import com.progresssoft.dao.FilesInfoDao;
import com.progresssoft.entity.FileInfo;
import com.progresssoft.entity.ValidDeals;
import com.progresssoft.util.HibernateUtil;

@Repository
public class FilesInfoDaoImpl implements FilesInfoDao {
	
	@Autowired
    private HibernateUtil hibernateUtil;
	
	@Override
	public long createNewFile(String fileName) {
		FileInfo filebean = new FileInfo();
		filebean.setFileName(fileName);
		long fileId = (long) hibernateUtil.create(filebean);
		return fileId;
	}

	@Override
	public FileInfoBean getFileByName(String fileName) {
		Session session = hibernateUtil.getCurrentSession();
		Query query = session.createQuery("FROM FileInfo as fi WHERE fi.fileName = :fileName");
		query.setParameter("fileName", fileName);
		FileInfo fileInfo =  (FileInfo) query.uniqueResult();
		if(fileInfo == null){
			return null;
		}else{
			return cnvertEntityToBean(fileInfo); 
		}	
	}
	
	@Override
	public List<FileInfoBean> getAllFiles() {
		Session session = hibernateUtil.getCurrentSession();
		Query query = session.createQuery("FROM FileInfo");
		List<FileInfoBean> fileInfoBean = getFileInfo(query.list());
		return fileInfoBean;
	}

	private List<FileInfoBean> getFileInfo(List<FileInfo> fileInfoList) {
		List<FileInfoBean> fileInfoBeans = new ArrayList<FileInfoBean>();
		for(FileInfo fileInfo : fileInfoList){
			FileInfoBean fileInfoBean = cnvertEntityToBean(fileInfo);
			fileInfoBeans.add(fileInfoBean);
		}
		return fileInfoBeans;
	}

	//Convert Entity to Bean
	private FileInfoBean cnvertEntityToBean(FileInfo fileInfo){
		FileInfoBean fileInfoBean = new FileInfoBean();
		fileInfoBean.setId(fileInfo.getId());
		fileInfoBean.setFileName(fileInfo.getFileName());
		return fileInfoBean;
	}
}
