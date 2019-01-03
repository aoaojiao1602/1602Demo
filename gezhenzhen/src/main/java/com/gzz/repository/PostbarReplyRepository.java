package com.gzz.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.gzz.entity.Postbar;
import com.gzz.entity.PostbarReply;

public interface PostbarReplyRepository extends JpaRepository<PostbarReply, Integer> {
	
	/*
	 * 回复主贴
	 */
	@Modifying
	@Transactional
	@Query(value = "insert into postbar_replytb(u_id,postbar_reply_postbar_id,postbar_reply_content)values"
			+ "(?1,?2,?3)", nativeQuery = true)
	public int putPostbarReply(Integer uId, Integer postbarReplyPostbarId,String postbarReplyContent);
	
	/*
	 * 查询回复数
	 * By PostbarId
	 */
	@Query(value="select count(*) from postbar_replytb where postbar_reply_postbar_id=?1", nativeQuery = true)
	public int getPostbarReplyCountByPostbarId(Integer postbarReplyPostbarId);
	
	/*
	 * 查询自己发表的回复数
	 * By uId
	 */
	@Query(value="select count(*) from postbar_replytb where u_id=?1", nativeQuery = true)
	public int getPostbarReplyCountByuId(Integer uId);
	
	/*
	 * 查询最后回复的uId和时间
	 */
	@Query(value="SELECT * FROM postbar_replytb WHERE postbar_reply_postbar_id=?1 ORDER BY postbar_reply_create_time DESC LIMIT 0,1", nativeQuery = true)
	public PostbarReply getLastPostbarReply(Integer postbarReplyPostbarId);
	
	/*
	 * 删除自己发表的回复
	 */
	@Modifying
	@Transactional
	@Query(value = "delete from postbar_replytb where u_id=?1 and postbar_reply_id=?2", nativeQuery = true)
	public int deletePostbarReply(Integer uId,Integer postbarReplyId);
	
	/*
	 * 查询被回复数
	 */
	@Query(value="SELECT COUNT(*) FROM postbar_replytb WHERE postbar_reply_postbar_id IN (SELECT postbar_id FROM postbartb WHERE u_id=?1)", nativeQuery = true)
	public int getPostbarReplyedCountByuId(Integer uId);
	
	/*
	 * 回复分页
	 */
	@Query(value="SELECT * FROM postbar_replytb WHERE postbar_reply_postbar_id =?1",nativeQuery=true)
	public Page<PostbarReply> getPostbarReplyPageByPostbarReplyPostbarId(Integer postbarReplyPostbarId,Pageable pageable);
	
	/**
	 * 个人中心回复分页
	 * @param uId
	 * @param pageable
	 * @return
	 */
	@Query(value="SELECT * FROM postbar_replytb WHERE u_id =?1",nativeQuery=true)
	public Page<PostbarReply> getPostbarReplyPageByuId(Integer uId,Pageable pageable); 
}
