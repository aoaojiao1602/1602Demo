package com.gzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.gzz.entity.PostbarReplyGood;

public interface PostbarReplyGoodRepository extends JpaRepository<PostbarReplyGood, Integer> {
	
	/*
	 * 回复顶贴
	 */
	@Modifying
	@Transactional
	@Query(value = "insert into postbar_reply_goodtb(postbar_reply_good_postbar_reply_id,u_id) values(?1,?2)", nativeQuery = true)
	public int putPostbarReplyGood (Integer postbarReplyGoodPostbarReplyId,Integer uId);
	
	/*
	 * 回复取消顶贴
	 */
	@Modifying
	@Transactional
	@Query(value = "delete from postbar_reply_goodtb where postbar_reply_good_postbar_reply_id=?1 and u_id=?2", nativeQuery = true)
	public int deletePostbarReplyGood (Integer postbarReplyGoodPostbarReplyId,Integer uId);
	
	/*
	 * 查询用户是否对回复已经点过赞
	 */
	@Query(value = "select * from postbar_reply_goodtb where postbar_reply_good_postbar_reply_id=?1 and u_id=?2", nativeQuery = true)
	public PostbarReplyGood getPostbarReplyGood (Integer postbarReplyGoodPostbarReplyId,Integer uId);
	
	/*
	 * 查询点赞数
	 * by PostbarReplyId
	 */
	@Query(value = "select count(*) from postbar_reply_goodtb where postbar_reply_good_postbar_reply_id=?1", nativeQuery = true)
	public int getPostbarReplyGoodCountByPostbarReplyId (Integer postbarReplyGoodPostbarReplyId);
	
	/*
	 * 查询获赞数
	 * by uId
	 */
	@Query(value="SELECT COUNT(*) FROM postbar_reply_goodtb WHERE postbar_reply_good_postbar_reply_id IN(SELECT postbar_reply_id FROM postbar_replytb WHERE u_id=?1)", nativeQuery=true)
	public int getPostbarReplyGoodCountByuId(Integer uId);
}
