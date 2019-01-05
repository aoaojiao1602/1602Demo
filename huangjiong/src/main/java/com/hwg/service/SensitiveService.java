package com.hwg.service;

import java.util.List;

import com.hwg.entity.Sensitive;

/**
 * @Description 铭感词service
 * @author HJiong
 * @time 2019年1月4日 上午11:04:40
 */
public interface SensitiveService {
	/**
	 *	添加
	 * @param model
	 * @return
	 */
	public Object addSensitive(Sensitive model);
	
	
	/**
	 *	查询所有
	 * @return
	 */
	public List<Sensitive> getAll();

}
