package com.gzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.gzz.entity.CommentReport;

public interface CommentReportReopsitory extends JpaRepository<CommentReport, Integer>{
	//对评论进行举报
	@Query(value="INSERT INTO commentreporttb (comment_report_comment_id,comment_report_uid,comment_report_content) VALUE(?1,?2,?3)",nativeQuery=true)
	@Modifying
	public int putCommentReport(Integer commentId,Integer commentUid,String reportContent);

}
