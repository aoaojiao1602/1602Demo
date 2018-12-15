package com.gzz.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.gzz.entity.Project;

public interface ProjectService {
	//修改主题
	public int postProject(String projectTitle,String projectContent,Integer projectId);
	//查询所有主题
	public Page<Project> findAll(String projectCreatetime,Integer page, Integer size);
	//发表主题(所属的讨论区模块是老师答疑区)
	public int putProject(Integer clazzId,String projectContent,String projectCreatetime,String projectTitle,Integer projectUid,Integer moduleId);
	//发表主题(所属的讨论区模块是综合讨论区)
	public int putProjects(String projectContent,String projectCreatetime,String projectTitle,Integer projectUid,Integer moduleId);
	//分页查询用户自己所关注的主题
	public List<Project> getProjectByProjectState(Integer projectState,Integer uId);

}
