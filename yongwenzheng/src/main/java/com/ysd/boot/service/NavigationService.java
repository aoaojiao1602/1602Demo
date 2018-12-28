package com.ysd.boot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ysd.boot.entity.Navigation;

public interface NavigationService {

	
	/**
	 * 添加导航信息
	 * @param navName
	 */
	  public int addNavigation(String navName);
	 
	 
	 /**
	   * 通过id删除导航信息
	   * @param navId
	   * @return
	   */
	  public int deleteNavigation(Integer navId);
	  
	  
	  /***
	   * 通过id修改导航信息
	   * @param navId
	   * @param navName
	   * @return
	   */
	  public int updateNavigation(Integer navId,String navName);
	  
	  
	  /**
	   * 得到所有导航信息
	   * @return
	   */
	  public List<Navigation> getALLNavigationList();
	  
	  /***
	   * 通过导航名称分页查询
	   * @param page
	   * @param rows
	   * @param navName
	   * @return
	   */
	  public Page<Navigation> queryNavigationByPage(Integer page,Integer rows,String navName);
}
