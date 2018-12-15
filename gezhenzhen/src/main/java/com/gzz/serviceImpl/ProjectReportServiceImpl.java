package com.gzz.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.gzz.repository.ProjectReoprtRepository;
import com.gzz.service.ProjectReportService;
@Service
public class ProjectReportServiceImpl implements ProjectReportService {
	@Autowired
	private ProjectReoprtRepository repository;
	//对主题进行举报
	@Transactional
	public int putProjectReport(String reportContent, Integer reportUid, Integer projectId) {
		return repository.putProjectReport(reportContent, reportUid, projectId);
	}
	
	

}
