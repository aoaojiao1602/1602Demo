package com.gzz.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.gzz.entity.Project;

public interface ProjectService {
	//修改主题
	public int postProject(String projectTitle,String projectContent,Integer projectId);
	//查询所有主题
	public Page<Project> findAll(Integer page, Integer size);
	//分页查询所有老师答疑区的主题
	public Page<Project>  findAllTes(Integer moduleId,Integer page,Integer size);
	//分页查询所有课堂答疑区的主题
	public Page<Project> findAllClazz(Integer moduleId,Integer page,Integer size);
	//按照投票数进行查询
	public Page<Project> getProjectCount(Integer page,Integer size);
	//查询所有的主题
	/*public Page<Project> findAlls(Integer page,Integer size);*/
	//发表主题(所属的讨论区模块是老师答疑区)
	public int putProject(Integer clazzId,String projectContent,String projectTitle,Integer projectUid,Integer moduleId);
	//发表主题(所属的讨论区模块是综合讨论区)
	public int putProjects(String projectContent,String projectTitle,Integer projectUid,Integer moduleId);
	//查询用户自己所关注的主题
	public List<Project> getProjectByProjectState(Integer projectState,Integer uId);
	//查询用户自己所关注的主题的id
	public List<Integer> getProjectId(Integer projectUid);
	//根据模块查询当前最先发布的主题
	public Project getProject(Integer projectModule);
	//查询某个帖子的浏览数
	public int getThroug(Integer projectId);
	//查询某个帖子的回复数
	public int getReply(Integer projectId);
	//查询某个帖子的投票数
	public int getCount(Integer projectId);

}
