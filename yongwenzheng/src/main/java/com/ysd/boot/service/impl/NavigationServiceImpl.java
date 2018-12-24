package com.ysd.boot.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.boot.dao.NavigationMapper;
import com.ysd.boot.entity.Navigation;
import com.ysd.boot.service.NavigationService;

@Service
public class NavigationServiceImpl implements NavigationService{

	@Autowired
	private NavigationMapper navigationMapper;
	
	/**
	 * 添加导航信息
	 * @param navName
	 */
	 @Transactional
	  public int addNavigation(String navName) {
		  
		  return navigationMapper.addNavigation(navName);
	  }
	 
	 
	 /**
	   * 通过id删除导航信息
	   * @param navId
	   * @return
	   */
	 @Transactional
	  public int deleteNavigation(Integer navId) {
		  
		  return navigationMapper.deleteNavigation(navId);
	  }
	  
	  
	  /***
	   * 通过id修改导航信息
	   * @param navId
	   * @param navName
	   * @return
	   */
	 @Transactional
	  public int updateNavigation(Integer navId,String navName) {
		  
		  return navigationMapper.updateNavigation(navId, navName);
	  }
	  
	  
	  /**
	   * 得到所有导航信息
	   * @return
	   */
	  public List<Navigation> getALLNavigationList(){
		  
		  return navigationMapper.findAll();
	  }
}
