package com.gzz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gzz.repository.CommentReportReopsitory;
import com.gzz.service.CommentReportService;
@Service
public class CommentReportServiceImpl implements CommentReportService {
	@Autowired
	private CommentReportReopsitory reopsitory;
	//对评论进行举报
	public int putCommentReport(Integer commentId,Integer commentUid,String reportContent) {
		return reopsitory.putCommentReport(commentId, commentUid, reportContent);
	}

}
