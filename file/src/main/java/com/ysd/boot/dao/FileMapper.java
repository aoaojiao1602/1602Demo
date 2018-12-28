package com.ysd.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ysd.boot.entity.FileM;

public interface FileMapper  extends JpaRepository<FileM, Integer>{
	
	
}
