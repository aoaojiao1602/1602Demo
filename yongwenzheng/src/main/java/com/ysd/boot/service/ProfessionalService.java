package com.ysd.boot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.ysd.boot.entity.Clazz;
import com.ysd.boot.entity.Professional;

public interface ProfessionalService {

	 /**
              * 通过departmentId得到Professional
       * @param departmentId
       * @return
    */
	public List<Professional> getAllProfessionalBydepartmentId(Integer departmentId);
	
	/**
	 * 通过id得到系信息
	 * @param id
	 * @return
	 */
	public Professional getAllById(Integer id);
	
	
	/**
	 * 添加系信息
	 * @param professionalName
	 * @param department_id
	 * @return
	 */
	public int addProfessional(String professionalName,Integer department_id);
	
	
	/**
	  * 通过id删除系信息
	 * @param professionalId
	 * @return
	 */
	public int deleteProfessional(Integer professionalId);
	
	/**
	  * 通过id修改系信息
	 * @param professionalId
	 * @param professionalName
	 * @param department_id
	 * @return
	 */
	public int updateProfessional(Integer professionalId,String professionalName,Integer department_id);

	/**
	 * 查询所有系信息
	 * @return
	 */
    public List<Professional> getAllProfessionalList();
    
    /**
           * 分页查询系信息
     * @param name
     * @param pageable
     * @return
    */
   public Page<Professional> queryProfessionalByPage(Integer page,Integer rows,String name);
   
   
    
}
