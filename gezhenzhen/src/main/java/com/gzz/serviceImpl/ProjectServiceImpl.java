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
	public Page<Project> findAll(String projectCreatetime,Integer page, Integer size){
		Sort sort=new Sort(Sort.Direction.DESC,"projectLastTime");
		Pageable pageable=new PageRequest(page, size,sort);
		//Pageable  pageable=new PageRequest(page, size);
		return repository.findAll(pageable);
	}
	@Transactional
	public int putProject(Integer clazzId, String projectContent, String projectCreatetime, String projectTitle,
			Integer projectUid, Integer moduleId) {
		return repository.putProject(clazzId, projectContent, projectCreatetime, projectTitle, projectUid, moduleId);
	}
	@Transactional
	public int putProjects(String projectContent, String projectCreatetime, String projectTitle, Integer projectUid,
			Integer moduleId) {
		return repository.putProjects(projectContent, projectCreatetime, projectTitle, projectUid, moduleId);
	}
	//分页查询用户自己所关注的主题
	@Transactional
	public List<Project> getProjectByProjectState(Integer projectState,Integer uId) {
		return repository.getProjectByProjectState(projectState, uId);
	}

}
