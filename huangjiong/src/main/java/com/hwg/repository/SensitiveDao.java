package com.hwg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hwg.entity.Sensitive;

/**
 * @Description 铭感词Dao
 * @author HJiong
 * @time 2019年1月4日 上午11:03:40
 */
public interface SensitiveDao extends JpaRepository<Sensitive, Integer> {
	
}
