package com.ysd.boot.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ysd.boot.dao.ProfessionalMapper;
import com.ysd.boot.entity.Professional;
import com.ysd.boot.service.ProfessionalService;

@Service
public class ProfessionalServiceImpl implements ProfessionalService{

	@Autowired
	private ProfessionalMapper professionalMapper;
	
	 /**
              * 通过departmentId得到Professional
       * @param departmentId
       * @return
     */
   public List<Professional> getAllProfessionalBydepartmentId(Integer departmentId){
	   
	   return professionalMapper.getAllProfessionalBydepartmentId(departmentId);
   }
	
	/**
	 * 通过id得到系信息
	 * @param id
	 * @return
	 */
	public Professional getAllById(Integer id) {
		
		return professionalMapper.getOne(id);
	}
	
	
	
	/**
	 * 添加系信息
	 * @param professionalName
	 * @param department_id
	 * @return
	 */
	@Transactional
	public int addProfessional(String professionalName,Integer department_id) {
		
		return professionalMapper.addProfessional(professionalName, department_id);
	}
	
	
	/**
	  * 通过id删除系信息
	 * @param professionalId
	 * @return
	 */
	@Transactional
	public int deleteProfessional(Integer professionalId) {
		
		return professionalMapper.deleteProfessional(professionalId);
	}
	
	/**
	  * 通过id修改系信息
	 * @param professionalId
	 * @param professionalName
	 * @param department_id
	 * @return
	 */
	@Transactional
	public int updateProfessional(Integer professionalId,String professionalName,Integer department_id) {
		
		return professionalMapper.updateProfessional(professionalId, professionalName, department_id);
	}
	
	/**
	 * 查询所有系信息
	 * @return
	 */
    public List<Professional> getAllProfessionalList(){
    	
    	return professionalMapper.findAll();
    }
    
    
    
     /**
            * 分页查询系信息
      * @param name
      * @param pageable
      * @return
   */
    public Page<Professional> queryProfessionalByPage(Integer page,Integer rows,String name){
    	
    	  Pageable pageable = new PageRequest(page-1, rows);
		  
		  return professionalMapper.findByProfessionalNameContaining(name, pageable);
    }
}
