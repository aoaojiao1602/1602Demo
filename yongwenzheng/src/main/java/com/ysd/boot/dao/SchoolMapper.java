package com.ysd.boot.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ysd.boot.entity.School;

public interface SchoolMapper extends JpaRepository<School, Integer>,JpaSpecificationExecutor<School>{

	
	
	/***
	 *修改学校
	 * @param school
	 * @return
	 */
	@Modifying
	@Query(value = "UPDATE schooltb SET school_name = :schoolName WHERE school_id = :schoolId", nativeQuery = true)
	public int updateSchool(String schoolName,Integer schoolId);
	
	/**
	 * 删除学校
	 * @param id
	 * @return
	 */
	 @Modifying
	 @Query(value = "DELETE FROM schooltb WHERE school_id = ?1 " , nativeQuery = true)
	public int deleteSchool(@Param("id")Integer id);
	 
	 /***
		 *添加学校
		 * @param school
		 * @return
		 */   
    @Modifying
    @Query(value = "INSERT INTO schooltb (school_name) VALUES(?1)", nativeQuery = true)
    public int addSchool(String schoolName);
      
    /**
     	* 分页查询班级
     	* @param name
     	* @param pageable
     	* @return
     	*/
    public Page<School> findBySchoolNameContaining(String name,Pageable pageable);
	
}
