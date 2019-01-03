package com.gzz.service;

public interface PostbarReportService {
	
	/*
	 * 对主贴举报
	 */
	public int putPostbarReport(Integer uId, Integer postbarReportPostbarId, String postbarReportContent);
}
