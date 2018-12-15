package com.gzz.service;

public interface ProjectReportService {
	//对主题进行举报
	public int putProjectReport(String reportContent,Integer reportUid,Integer projectId);

}
