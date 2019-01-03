package com.gzz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.gzz.entity.PostbarComment;

public interface PostbarCommentService {
	
	/*
	 * 评论回复
	 */
	public int putPostbarComment(Integer uId, Integer postbarCommentPostbarReplyId,String postbarCommentContent);
	
	/*
	 * 查询评论数
	 * By PostbarReplyId
	 */
	public int getPostbarCommentCountByPostbarReplyId(Integer postbarCommentPostbarReplyId);
	
	/*
	 * 查询评论数
	 * By uId
	 */
	public int getPostbarCommentCountByuId(Integer uId);
	
	/*
	 * 删除自己发表的评论
	 */
	public int deletePostbarComment(Integer postbarCommentId,Integer uId);
	
	/*
	 * 删除评论
	 * by PostbarCommentPostbarReplyId
	 */
	public int deletePostbarCommentByPostbarCommentPostbarReplyId(Integer postbarCommentPostbarReplyId);
	
	/*
	 * 查询被评论数
	 */
	public int getPostbarCommentedCountByuId(Integer uId);
	
	/**
	 * 个人中心评论分页
	 * @param uId
	 * @param pageable
	 * @return
	 */
	public Page<PostbarComment> getPostbarCommentPageByuId(Integer uId,Integer page,Integer size);
	
	/**
	 * 评论分页
	 * @param postbarCommentPostbarReplyId
	 * @param pageable
	 * @return
	 */
	public Page<PostbarComment> getPostbarCommentPageByPostbarCommentPostbarReplyId(Integer postbarCommentPostbarReplyId,Integer page,Integer size);
}
