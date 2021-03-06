package com.gzz.service;

import org.springframework.data.domain.Page;

import com.gzz.entity.Project;
import com.gzz.entity.ProjectCount;

public interface ProjectCountService {
	//查询当前用户有没有进行点踩
	public int getUidCount(Integer projectId,Integer projectCountUids);
	//对主题进行点赞
	public int putProjectCount(Integer projectId,Integer projectCountUids);
	//查询当前用户有没有对该主题进行点赞
	public int getUid(Integer projectId,Integer projectCountUids);
	//如果当前用户已经对该主题进行了点赞则进行取消点赞
	public int deleteProjectCount(Integer projectId,Integer ProjectCountUids);
	//按照投票数进行查询
/*	public Page<Project> getProjectCount(Integer page,Integer size);
*/

}
