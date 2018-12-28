package com.ysd.boot.service;

import java.util.List;

import com.ysd.boot.entity.FileM;

public interface FileService {

	/**
	 * 添加文件信息
	 * @param file
	 * @return
	 */
	public int  insertFileByFile(FileM file);
	
	
	/***
	 * 查询所有文件信息
	 * @return
	 */
	public List<FileM> getAll();
	
	
	
	
	
	
	
	

	
}
