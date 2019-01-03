package com.gzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.gzz.entity.PostbarReplyNotGood;

public interface PostbarReplyNotGoodRepository extends JpaRepository<PostbarReplyNotGood, Integer> {
	
	/*
	 * 回复踩贴
	 */
	@Modifying
	@Transactional
	@Query(value = "insert into postbar_reply_not_goodtb(postbar_reply_not_good_postbar_reply_id,u_id) values(?1,?2)", nativeQuery = true)
	public int putPostbarReplyNotGood (Integer postbarReplyNotGoodPostbarReplyId,Integer uId);
	
	/*
	 * 回复取消踩贴
	 */
	@Modifying
	@Transactional
	@Query(value = "delete from postbar_reply_not_goodtb where postbar_reply_not_good_postbar_reply_id=?1 and u_id=?2", nativeQuery = true)
	public int deletePostbarReplyNotGood (Integer postbarReplyNotGoodPostbarReplyId,Integer uId);
	
	/*
	 * 查询用户是否对回复已经踩帖
	 */
	@Query(value = "select * from postbar_reply_not_goodtb where postbar_reply_not_good_postbar_reply_id=?1 and u_id=?2", nativeQuery = true)
	public PostbarReplyNotGood getPostbarReplyNotGood (Integer postbarReplyNotGoodPostbarReplyId,Integer uId);
	
	/*
	 * 查询踩帖数
	 */
	@Query(value = "select count(*) from postbar_reply_not_goodtb where postbar_reply_not_good_postbar_reply_id=?1", nativeQuery = true)
	public int getPostbarReplyNotGoodCount (Integer postbarReplyNotGoodPostbarReplyId);
}
