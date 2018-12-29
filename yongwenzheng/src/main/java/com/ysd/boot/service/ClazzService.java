package com.ysd.boot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ysd.boot.entity.Clazz;

public interface ClazzService {

	/***
	 * 通过学生id修改班级id
	 * @param cid
	 * @param sid
	 * @return
	 */
	public int updatejigou(Integer cid,Integer sid);
	
	
	/***
	 * 通过professional_id得到class_id
	 * @param pid
	 * @return
	 */
	public int getCidByPid(Integer pid);
	
	/****
	 * 通过学生id得到班级id
	 * @param sid
	 * @return
	 */
	public int getCidBysid(Integer sid);
	
	/**
	 * 通过id得到班级信息
	 * @param id
	 * @return
	 */
	public Clazz getAllById(Integer id);
	
	
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
    
    /**
            * 分页查询班级
      * @param name
      * @param pageable
      * @return
    */
    public Page<Clazz> queryClazzByPage(Integer page,Integer rows,String name);

}
