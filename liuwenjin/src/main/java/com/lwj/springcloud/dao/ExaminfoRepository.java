package com.lwj.springcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lwj.springcloud.entity.Examinfo;

public interface ExaminfoRepository extends JpaRepository<Examinfo, Integer>,JpaSpecificationExecutor<Examinfo> {

}
