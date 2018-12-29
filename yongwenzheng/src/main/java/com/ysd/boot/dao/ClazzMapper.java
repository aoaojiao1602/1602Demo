package com.ysd.boot.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ysd.boot.entity.Clazz;

public interface ClazzMapper extends JpaRepository<Clazz, Integer>,JpaSpecificationExecutor<Clazz>{	  
	 
	/***
	 * 通过学生id修改班级id
	 * @param cid
	 * @param sid
	 * @return
	 */
	@Modifying
	@Query(value = "UPDATE users_clazz SET clazz_users_id =?1  WHERE users_clazz_id =?2 ", nativeQuery = true)
	public int updatejigou(@Param("cid")Integer cid,@Param("sid")Integer sid);
	
	/***
	 * 通过professional_id得到class_id
	 * @param pid
	 * @return
	 */
	@Query(value = "SELECT class_id FROM clazztb WHERE professional_id=?1", nativeQuery = true)
	public int getCidByPid(@Param("pid")Integer pid);
	
	
	/****
	 * 通过学生id得到班级id
	 * @param sid
	 * @return
	 */
	@Query(value = "SELECT clazz_users_id FROM users_clazz WHERE users_clazz_id=?1", nativeQuery = true)
	public int getCidBysid(Integer sid);
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
	  
	  /**
	      * 分页查询班级
	   * @param name
	   * @param pageable
	   * @return
	   */
	  public Page<Clazz> findByClassNameContaining(String name,Pageable pageable);
}
