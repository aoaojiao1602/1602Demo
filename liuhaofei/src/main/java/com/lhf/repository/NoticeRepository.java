package com.lhf.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.lhf.entity.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Integer> ,JpaSpecificationExecutor<Notice>{
	//添加课程
	@Query(value="INSERT INTO notice (notice_content,notice_course,notice_name,notice_time)values" 
			+ "(:#{#n.noticeContent},:#{#n.noticeCourse},:#{#n.noticeName},:#{#n.noticeTime})", nativeQuery = true)
	@Modifying
	@Transactional
	public int putNotice(@Param("n") Notice n);
	//删除公告
	@Query(value = "DELETE FROM notice WHERE notice_id =?1", nativeQuery = true)
	@Modifying
	@Transactional
	public int deleteNoticeByid(Integer noticeId);
	//修改公告
	@Query(value="UPDATE notice SET notice_content=:#{#n.noticeContent},notice_course=:#{#n.noticeCourse},notice_name=:#{#n.noticeName} WHERE notice_id=:#{#n.noticeId}", nativeQuery = true)
	@Modifying
	@Transactional
	public int postNotice(@Param("n") Notice n);
}