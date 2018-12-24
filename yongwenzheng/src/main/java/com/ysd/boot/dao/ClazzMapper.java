package com.ysd.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ysd.boot.entity.Clazz;

public interface ClazzMapper extends JpaRepository<Clazz, Integer>,JpaSpecificationExecutor<Clazz>{

	  //通过id得到班级id
	  @Query(value = "SELECT clazz_users_id FROM users_clazz WHERE users_clazz_id=?1" , nativeQuery = true)
	  public Integer getClazzIdBytId(Integer sid);
	  
	  
	  /**
	      * 添加班级信息
	   * @param className
	   * @param professional_id
	   * @return
	   */
	  @Modifying
	  @Query(value = "INSERT INTO clazztb (class_name,professional_id) VALUES(?1,?2)", nativeQuery = true)
	  public int addClazz(@Param("className")String className,@Param("professional_id")Integer professional_id);
	  
	  /***
	       * 通过id删除班级信息
	   * @param classId
	   * @return
	   */
	  @Modifying
	  @Query(value = "DELETE FROM clazztb WHERE class_id = ?1 " , nativeQuery = true)
	  public int deleteClazz(@Param("classId")Integer classId);
	
	  /**
	     * 通过id修改班级信息
	   * @return
	   */
	  @Modifying
	  @Query(value = "UPDATE clazztb SET class_name = ?2,professional_id = ?3 WHERE class_id = ?1", nativeQuery = true)
	  public int updateClazz(@Param("classId")Integer classId,@Param("className")String className,@Param("professional_id")Integer professional_id);
	  
}
