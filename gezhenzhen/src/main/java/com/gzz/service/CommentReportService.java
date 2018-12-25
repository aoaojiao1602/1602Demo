package com.gzz.service;

public interface CommentReportService {
	//对评论进行举报
	public int putCommentReport(Integer commentId,Integer commentUid,String reportContent);

}
