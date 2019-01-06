package com.gzz.serviceImpl;

import javax.transaction.Transactional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gzz.entity.Project;
import com.gzz.entity.ProjectCount;
import com.gzz.repository.ProjectCountReopsitory;
import com.gzz.service.ProjectCountService;
@Service
public class ProjectCountServiceImpl implements ProjectCountService {
	@Autowired
    private ProjectCountReopsitory reopsitory;
	@Transactional
	public int putProjectCount(Integer projectId, Integer projectCountUids) {
		return reopsitory.putProjectCount(projectId, projectCountUids);
	}

	@Transactional
	@Override
	public int deleteProjectCount(Integer projectId, Integer ProjectCountUids) {
		return reopsitory.deleteProjectCount(projectId, ProjectCountUids);
	}

	@Transactional
	public int getUid(Integer projectId, Integer projectCountUids) {
		return reopsitory.getUid(projectId, projectCountUids);
	}
	@Transactional
	public int getUidCount(Integer projectId,Integer projectCountUids) {
		return reopsitory.getUidCount(projectId, projectCountUids);
	}
	/*@Transactional
	public Page<Project> getProjectCount(Integer page,Integer size){
		Pageable pageable=new PageRequest(page, size);
		return reopsitory.getProjectCount(pageable);
	}
*/
}
