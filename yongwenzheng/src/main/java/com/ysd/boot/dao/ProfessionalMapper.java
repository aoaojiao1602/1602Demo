package com.ysd.boot.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ysd.boot.entity.Professional;

public interface ProfessionalMapper extends JpaRepository<Professional, Integer>,JpaSpecificationExecutor<Professional>{	
	
	     /**
	             * 通过departmentId得到Professional
	       * @param departmentId
	       * @return
	       */
	    @Query(value = "SELECT * FROM professionaltb WHERE department_id=?1", nativeQuery = true)
	    public List<Professional> getAllProfessionalBydepartmentId(Integer departmentId);
	
		/**
		 * 添加系信息
		 * @param professionalName
		 * @param department_id
		 * @return
		 */
		@Modifying
		@Query(value = "INSERT INTO professionaltb (professional_name,department_id) VALUES(?1,?2)", nativeQuery = true)
		public int addProfessional(@Param("professionalName")String professionalName,@Param("department_id")Integer department_id);
		
		/**
		  * 通过id删除系信息
		 * @param professionalId
		 * @return
		 */
		@Modifying
		@Query(value = "DELETE FROM professionaltb WHERE professional_id = ?1 " , nativeQuery = true)
		public int deleteProfessional(@Param("professionalId")Integer professionalId);
		
		/**
		  * 通过id修改系信息
		 * @param professionalId
		 * @param professionalName
		 * @param department_id
		 * @return
		 */
		@Modifying
		@Query(value = "UPDATE professionaltb SET professional_name = ?2,department_id =?3  WHERE professional_id = ?1", nativeQuery = true)
		public int updateProfessional(@Param("professionalId")Integer professionalId,@Param("professionalName")String professionalName,@Param("department_id")Integer department_id);

        /***
                  * 分页查询
         * @param name
         * @param pageable
         * @return
         */
        public Page<Professional> findByProfessionalNameContaining(String name,Pageable pageable);












}
