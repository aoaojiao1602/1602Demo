package com.gzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.gzz.entity.PostbarCommentGood;

public interface PostbarCommentGoodRepository extends JpaRepository<PostbarCommentGood, Integer> {
	
	/*
	 * 评论顶贴
	 */
	@Modifying
	@Transactional
	@Query(value = "insert into postbar_comment_goodtb(postbar_comment_good_postbar_comment_id,u_id) values(?1,?2)", nativeQuery = true)
	public int putPostbarCommentGood (Integer postbarCommentGoodPostbarCommentId,Integer uId);
	
	/*
	 * 评论取消顶贴
	 */
	@Modifying
	@Transactional
	@Query(value = "delete from postbar_comment_goodtb where postbar_comment_good_postbar_comment_id=?1 and u_id=?2", nativeQuery = true)
	public int deletePostbarCommentGood (Integer postbarCommentGoodPostbarCommentId,Integer uId);
	
	/*
	 * 查询用户是否对评论已经点过赞
	 */
	@Query(value = "select * from postbar_comment_goodtb where postbar_comment_good_postbar_comment_id=?1 and u_id=?2", nativeQuery = true)
	public PostbarCommentGood getPostbarCommentGood (Integer postbarCommentGoodPostbarCommentId,Integer uId);
	
	/*
	 * 查询点赞数
	 * by PostbarCommentId
	 */
	@Query(value = "select count(*) from postbar_comment_goodtb where postbar_comment_good_postbar_comment_id=?1", nativeQuery = true)
	public int getPostbarCommentGoodCountByPostbarComentId (Integer postbarCommentGoodPostbarCommentId);
	
	/*
	 * 查询获赞数
	 * by uId
	 */
	@Query(value="SELECT COUNT(*) FROM postbar_comment_goodtb WHERE postbar_comment_good_postbar_comment_id IN(SELECT postbar_comment_id FROM postbar_commenttb WHERE u_id=?1)", nativeQuery=true)
	public int getPostbarCommentGoodCountByuId(Integer uId);
}
