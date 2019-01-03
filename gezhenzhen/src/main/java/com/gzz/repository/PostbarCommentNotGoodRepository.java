package com.gzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.gzz.entity.PostbarCommentNotGood;

public interface PostbarCommentNotGoodRepository extends JpaRepository<PostbarCommentNotGood, Integer> {
	
	/*
	 * 评论踩贴
	 */
	@Modifying
	@Transactional
	@Query(value = "insert into postbar_comment_not_goodtb(postbar_comment_not_good_postbar_comment_id,u_id) values(?1,?2)", nativeQuery = true)
	public int putPostbarCommentNotGood (Integer postbarCommentNotGoodPostbarCommentId,Integer uId);
	
	/*
	 * 评论取消踩贴
	 */
	@Modifying
	@Transactional
	@Query(value = "delete from postbar_comment_not_goodtb where postbar_comment_not_good_postbar_comment_id=?1 and u_id=?2", nativeQuery = true)
	public int deletePostbarCommentNotGood (Integer postbarCommentNotGoodPostbarCommentId,Integer uId);
	
	/*
	 * 查询用户是否对评论已经踩帖
	 */
	@Query(value = "select * from postbar_comment_not_goodtb where postbar_comment_not_good_postbar_comment_id=?1 and u_id=?2", nativeQuery = true)
	public PostbarCommentNotGood getPostbarCommentNotGood (Integer postbarCommentNotGoodPostbarCommentId,Integer uId);
	
}
