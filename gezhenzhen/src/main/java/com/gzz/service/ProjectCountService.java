package com.gzz.service;

import com.gzz.entity.ProjectCount;

public interface ProjectCountService {
	//对主题进行点赞
	public int putProjectCount(Integer projectId,Integer projectCountUids);
	//查询当前用户有没有对该主题进行点赞
	public int getUid(Integer projectId,Integer projectCountUids);
	//如果当前用户已经对该主题进行了点赞则进行取消点赞
	public int deleteProjectCount(Integer projectId,Integer ProjectCountUids);


}
