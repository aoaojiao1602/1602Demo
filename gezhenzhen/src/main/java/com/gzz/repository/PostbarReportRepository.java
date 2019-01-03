package com.gzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.gzz.entity.PostbarReport;

public interface PostbarReportRepository extends JpaRepository<PostbarReport, Integer> {
	
	/*
	 * 对主贴举报
	 */
	@Modifying
	@Transactional
	@Query(value = "insert into postbar_reporttb(u_id,postbar_report_postbar_id,postbar_report_content) values(?1,?2,?3)", nativeQuery = true)
	public int putPostbarReport(Integer uId, Integer postbarReportPostbarId, String postbarReportContent);
}
