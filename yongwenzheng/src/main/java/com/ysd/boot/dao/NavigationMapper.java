package com.ysd.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ysd.boot.entity.Navigation;

public interface NavigationMapper extends JpaRepository<Navigation, Integer>,JpaSpecificationExecutor<Navigation>{

	/**
	 * 添加导航信息
	 * @param navName
	 */
	  @Modifying
	  @Query(value = "INSERT INTO navigation (nav_name) VALUES(?1)", nativeQuery = true)
	  public int addNavigation(@Param("navName")String navName);
	  
	  
	  /**
	   * 通过id删除导航信息
	   * @param navId
	   * @return
	   */
	  @Modifying
	  @Query(value = "DELETE FROM navigation WHERE nav_id = ?1", nativeQuery = true)
	  public int deleteNavigation(@Param("navId")Integer navId);
	  
	  
	  /***
	   * 通过id修改导航信息
	   * @param navId
	   * @param navName
	   * @return
	   */
	  @Modifying
	  @Query(value = "UPDATE navigation SET nav_name = ?2 WHERE nav_id = ?1", nativeQuery = true)
	  public int updateNavigation(@Param("navId")Integer navId,@Param("navName")String navName);
	  
}
