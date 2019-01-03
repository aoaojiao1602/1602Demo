package com.gzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.gzz.entity.PostbarCommentReport;

public interface PostbarCommentReportRepository extends JpaRepository<PostbarCommentReport, Integer> {
	
	/*
	 * 对评论举报
	 */
	@Modifying
	@Transactional
	@Query(value = "insert into postbar_comment_reporttb(u_id,postbar_comment_report_postbar_comment_id,postbar_comment_report_content) values(?1,?2,?3)", nativeQuery = true)
	public int putPostbarCommentReport(Integer uId, Integer postbarCommentReportPostbarCommentId, String postbarCommentReportContent);
}
