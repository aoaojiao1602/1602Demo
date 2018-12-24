package com.ysd.boot.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.ysd.boot.entity.Clazz;

public interface ClazzService {

	/**
	 * 通过id得到班级信息
	 * @param id
	 * @return
	 */
	public Clazz getAllById(Integer id);
	
	/***
	 * 通过id得到班级id
	 * @param sid
	 * @return
	 */
	public Integer getClazzIdBytId(Integer sid);
	
	
	 /**
              * 添加班级信息
       * @param className
       * @param professional_id
       * @return
     */	
	public int addClazz(String className,Integer professional_id);
	
	 /***
              * 通过id删除班级信息
       * @param classId
       * @return
      */
	public int deleteClazz(Integer classId);
	
	 /**
               * 通过id修改班级信息
       * @return
      */
	public int updateClazz(Integer classId,String className,Integer professional_id);

	/**
	 * 得到所有班级信息
	 * @return
	 */
    public List<Clazz> getAllClazzList();

}
