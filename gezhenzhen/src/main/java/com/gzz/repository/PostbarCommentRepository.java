package com.gzz.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.gzz.entity.PostbarComment;

public interface PostbarCommentRepository extends JpaRepository<PostbarComment, Integer> {
	
	/*
	 * 评论回复
	 */
	@Modifying
	@Transactional
	@Query(value = "insert into postbar_commenttb(u_id,postbar_comment_postbar_reply_id,postbar_comment_content)values"
			+ "(?1,?2,?3)", nativeQuery = true)
	public int putPostbarComment(Integer uId, Integer postbarCommentPostbarReplyId,String postbarCommentContent);
	
	/*
	 * 查询评论数
	 * By PostbarReplyId
	 */
	@Query(value="select count(*) from postbar_commenttb where postbar_comment_postbar_reply_id=?1", nativeQuery = true)
	public int getPostbarCommentCountByPostbarReplyId(Integer postbarCommentPostbarReplyId);
	
	/*
	 * 查询评论数
	 * By uId
	 */
	@Query(value="select count(*) from postbar_commenttb where u_id=?1", nativeQuery = true)
	public int getPostbarCommentCountByuId(Integer uId);
	
	/*
	 * 删除自己发表的评论
	 */
	@Modifying
	@Transactional
	@Query(value = "delete from postbar_commenttb where postbar_comment_id=?1 and u_id=?2", nativeQuery = true)
	public int deletePostbarComment(Integer postbarCommentId,Integer uId);
	
	/*
	 * 删除评论
	 * by PostbarCommentPostbarReplyId
	 */
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM postbar_commenttb WHERE postbar_comment_postbar_reply_id=?1", nativeQuery = true)
	public int deletePostbarCommentByPostbarCommentPostbarReplyId(Integer postbarCommentPostbarReplyId);
	
	/*
	 * 查询被评论数
	 */
	@Query(value="SELECT COUNT(*) FROM postbar_commenttb WHERE postbar_comment_postbar_reply_id IN (SELECT postbar_reply_id FROM postbar_replytb WHERE u_id=?1)", nativeQuery = true)
	public int getPostbarCommentedCountByuId(Integer uId);
	
	/**
	 * 个人中心评论分页
	 * @param uId
	 * @param pageable
	 * @return
	 */
	@Query(value="SELECT * FROM postbar_commenttb WHERE u_id =?1",nativeQuery=true)
	public Page<PostbarComment> getPostbarCommentPageByuId(Integer uId,Pageable pageable);
	
	/**
	 * 评论分页
	 * @param postbarCommentPostbarReplyId
	 * @param pageable
	 * @return
	 */
	@Query(value="SELECT * FROM postbar_commenttb WHERE postbar_comment_postbar_reply_id =?1",nativeQuery=true)
	public Page<PostbarComment> getPostbarCommentPageByPostbarCommentPostbarReplyId(Integer postbarCommentPostbarReplyId,Pageable pageable);
}
