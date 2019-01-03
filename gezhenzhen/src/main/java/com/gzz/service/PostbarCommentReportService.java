package com.gzz.service;

public interface PostbarCommentReportService {
	
	/*
	 * 对评论举报
	 */
	public int putPostbarCommentReport(Integer uId, Integer postbarCommentReportPostbarCommentId, String postbarCommentReportContent);
}
