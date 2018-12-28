package com.ysd.boot.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.boot.dao.FileMapper;
import com.ysd.boot.entity.FileM;
import com.ysd.boot.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileMapper fileMapper;
	
	/**
	 * 添加文件信息
	 * @param file
	 * @return
	 */
	public int  insertFileByFile(FileM file) {
		Integer a;
		if (fileMapper.save(file)!=null) {
			a=1;
		}else {
			a=0;
		}
		return a;
		
	}
	
	/***
	 * 查询所有文件信息
	 * @return
	 */
	public List<FileM> getAll(){
		
		return fileMapper.findAll();
	}
	
	
	
	
	
}
