package com.gzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.gzz.entity.ReplyReport;

public interface ReplyReportRepository extends JpaRepository<ReplyReport, Integer>{
	//对回复进行举报
	@Query(value="INSERT  INTO replyreporttb (reply_report_uid,reply_report_reply_id,reply_report_content) VALUE(?1,?2,?3)",nativeQuery=true)
	@Modifying
	public int putReplyRepotr(Integer reportUid,Integer replyId,String reportContent);

}
