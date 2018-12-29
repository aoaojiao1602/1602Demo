package com.ysd.boot.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ysd.boot.dao.ClazzMapper;
import com.ysd.boot.entity.Clazz;
import com.ysd.boot.service.ClazzService;

@Service
public class ClazzServiceImpl implements ClazzService{

	@Autowired
	private ClazzMapper clazzMapper;
	
	
	/***
	 * 通过学生id修改班级id
	 * @param cid
	 * @param sid
	 * @return
	 */
	 @Transactional
	public int updatejigou(Integer cid,Integer sid) {
		 
		 return clazzMapper.updatejigou(cid, sid);
	 }
	
	
	/***
	 * 通过professional_id得到class_id
	 * @param pid
	 * @return
	 */
	public int getCidByPid(Integer pid) {
		
		return clazzMapper.getCidByPid(pid);
	}
	
	/****
	 * 通过学生id得到班级id
	 * @param sid
	 * @return
	 */
	public int getCidBysid(Integer sid) {
		
		return clazzMapper.getCidBysid(sid);
	}
	
	/**
	 * 通过id得到班级信息
	 * @param id
	 * @return
	 */
	public Clazz getAllById(Integer id) {
		return clazzMapper.getOne(id);
	}
	
	
	
	
	
	  /**
                * 添加班级信息
        * @param className
        * @param professional_id
        * @return
     */	
	  @Transactional
      public int addClazz(String className,Integer professional_id) {
		  
		  return clazzMapper.addClazz(className, professional_id);
	  }

        /***
                        * 通过id删除班级信息
            * @param classId
            * @return
        */
      @Transactional
      public int deleteClazz(Integer classId) {
    	  
    	  return clazzMapper.deleteClazz(classId);
      }

      /**
               * 通过id修改班级信息
       * @return
       */
      @Transactional
      public int updateClazz(Integer classId,String className,Integer professional_id) {
    	  
    	  return clazzMapper.updateClazz(classId, className, professional_id);
      }

       /**
                  * 得到所有班级信息
         * @return
        */
      public List<Clazz> getAllClazzList(){
    	  
    	  return clazzMapper.findAll();
      }
	
      /**
                * 分页查询班级
        * @param name
        * @param pageable
        * @return
         */
      public Page<Clazz> queryClazzByPage(Integer page,Integer rows,String name){
    	  Pageable pageable = new PageRequest(page-1, rows);
    	  return clazzMapper.findByClassNameContaining(name, pageable);
      }
	
}

