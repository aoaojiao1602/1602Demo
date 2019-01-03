package com.gzz.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gzz.entity.Project;
import com.gzz.repository.ProjectRepository;
import com.gzz.service.ProjectService;
@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository repository;
	//修改主题(只能修改自己所发表的主题)
	@Transactional
	public int postProject(String projectTitle, String projectContent, Integer projectId) {
		return repository.postProject(projectTitle, projectContent, projectId);
	}
	//查询所有的主题
	public Page<Project> findAll(Integer page, Integer size){
		Sort sort=new Sort(Sort.Direction.DESC,"projectCreatetime");
		Pageable pageable=PageRequest.of(page, size, sort);
		//System.err.println(projectCreatetime);
		return repository.findAll(pageable);
	}
	@Transactional
	public int putProject(Integer clazzId, String projectContent, String projectTitle,
			Integer projectUid, Integer moduleId) {
		return repository.putProject(clazzId, projectContent, projectTitle, projectUid, moduleId);
	}
	//发表主题
	@Transactional
	public int putProjects(String projectContent, String projectCreatetime, String projectTitle, Integer projectUid,
			Integer moduleId) {
		return repository.putProjects(projectContent, projectCreatetime, projectTitle, projectUid, moduleId);
	}
	//查询用户自己所关注的主题
	@Transactional
	public List<Project> getProjectByProjectState(Integer projectState,Integer uId) {
		return repository.getProjectByProjectState(projectState, uId);
	}
	//查询用户自己所关注的主题的id
	@Transactional
	public List<Integer> getProjectId(Integer projectUid){
		return repository.getProjectId(projectUid);
	}
	//根据模块查询当前最先发布的主题
	
	public Project getProject(Integer projectModule) {
		return repository.getProject(projectModule);
	}
	//查询某个帖子的浏览数
	public int getThroug(Integer projectId) {
		return repository.getThroug(projectId);
	}
	//查询某个帖子的回复数
	public int getReply(Integer projectId) {
		return repository.getReply(projectId);
	}
	//查询某个帖子的投票数
	public int getCount(Integer projectId) {
		return repository.getCount(projectId);
	}
	//分页查询所有老师答疑区的主题
	public Page<Project> findAllTes(Integer moduleId, Integer page, Integer size) {
		Sort sort=new Sort(Sort.Direction.DESC,"project_createtime");
		Pageable pageable=new PageRequest(page, size,sort);
		return repository.findAllTes(moduleId, pageable);
	}
	//分页查询所有课程交流区的主题
	public Page<Project> findAllClazz(Integer moduleId, Integer page, Integer size) {
		Sort sort=new Sort(Sort.Direction.DESC,"project_createtime");
		Pageable pageable=new PageRequest(page, size,sort);
		return repository.findAllClazz(moduleId, pageable);
	}
	public Page<Project> getProjectCount(Integer page,Integer size){
		Pageable pageable=PageRequest.of(page, size);
		return repository.getProjectCount(pageable);
	}
	//查询所有的主题
	/*public Page<Project> findAlls(Integer page,Integer size){
		Pageable pageable=new PageRequest(page, size);
		return repository.findAll(pageable);
	}*/
}
