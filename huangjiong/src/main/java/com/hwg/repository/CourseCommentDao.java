package com.hwg.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.hwg.entity.Coursecomment;

/**
 * @Description 课程评论 Dao层
 * @author HJiong
 * @time 2018年12月14日 下午1:52:27
 */
public interface CourseCommentDao extends JpaRepository<Coursecomment, Integer>{
	
	/**
	 *根据条件查询课程评论
	 */
	public List<Coursecomment> findByCommentTimeBetween(String ksTime,String jsTime);
	
	/**
	 * 根据课程编号查询课程评论的总条数
	 * 
	 * @param comment
	 * @return
	 */
	@Query(value = "SELECT COUNT(*) FROM coursecommenttb WHERE comment_course_id = :#{#comment.commentCourseId}", nativeQuery = true)
	public int countCourseComment(@Param("comment") Coursecomment comment);

	/**
	 * 根据课程编号查询课程评价的平均星级
	 * 
	 * @param comment
	 * @return
	 */
	@Query(value = "SELECT AVG(comment_star) FROM coursecommenttb WHERE comment_course_id = :#{#comment.commentCourseId}", nativeQuery = true)
	public double getCommentStar(@Param("comment") Coursecomment comment);

	/**
	 * 给评论点赞
	 * 
	 * @param comment
	 * @return
	 */
	@Query(value = "UPDATE coursecommenttb SET comment_like=comment_like+1 WHERE comment_id=:#{#comment.commentId}", nativeQuery = true)
	@Modifying
	@Transactional
	public int updateCommentliked(@Param("comment") Coursecomment comment);
	
	@Query(value="select * from coursecommenttb where comment_course_id=?1 order by comment_like desc",nativeQuery=true)
	public List<Map<String, Object>> findByCid(Integer cid);
}
