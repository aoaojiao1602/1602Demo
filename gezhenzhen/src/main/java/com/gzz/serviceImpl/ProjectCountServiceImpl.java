package com.gzz.serviceImpl;

import javax.transaction.Transactional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
