package com.gzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.gzz.entity.PostbarReplyReport;

public interface PostbarReplyReportRepository extends JpaRepository<PostbarReplyReport, Integer> {
	
	/*
	 * 对回复举报
	 */
	@Modifying
	@Transactional
	@Query(value = "insert into postbar_reply_reporttb(u_id,postbar_reply_report_postbar_reply_id,postbar_reply_report_content) values(?1,?2,?3)", nativeQuery = true)
	public int putPostbarReplyReport(Integer uId, Integer postbarReplyReportPostbarReplyId, String postbarReplyReportContent);
}
