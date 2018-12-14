package com.hwg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hwg.entity.Learnrecord;

/**
 * @Description 学习记录 Dao层
 * @author HJiong
 * @time 2018年12月14日 下午1:52:51
 */
public interface LearnrecordDao extends JpaRepository<Learnrecord, Integer>{

}
