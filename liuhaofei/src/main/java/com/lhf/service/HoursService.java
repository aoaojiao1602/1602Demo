package com.lhf.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import com.lhf.entity.Hours;
import com.lhf.entity.HoursSearch;

public interface HoursService {

	
	//添加课时
	public int putHours(Hours h);
	
	
	//删除课时
	public int deleteHoursById(Integer hourId);
	
	
	//修改课时
	public int postHoursById(Hours h);

	
	//查看课时
	public Page<Hours> queryByDyHoursSQLPage(HoursSearch HSearch,Integer page,Integer size);

	
	/**
	 * 根据章节ID即父ID查询课时
	 * @param hourParentId
	 * @return
	 */
	public List<Hours> queryHoursByhourParentId(Integer hourParentId);
	
	
	
}
