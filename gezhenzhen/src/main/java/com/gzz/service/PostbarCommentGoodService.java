package com.gzz.service;

import com.gzz.entity.PostbarCommentGood;

public interface PostbarCommentGoodService {
	
	/*
	 * 评论顶贴
	 */
	public int putPostbarCommentGood (Integer postbarCommentGoodPostbarCommentId,Integer uId);
	
	/*
	 * 评论取消顶贴
	 */
	public int deletePostbarCommentGood (Integer postbarCommentGoodPostbarCommentId,Integer uId);
	
	/*
	 * 查询用户是否对评论已经点过赞
	 */
	public PostbarCommentGood getPostbarCommentGood (Integer postbarCommentGoodPostbarCommentId,Integer uId);
	
	/*
	 * 查询点赞数
	 * by PostbarCommentId
	 */
	public int getPostbarCommentGoodCountByPostbarComentId (Integer postbarCommentGoodPostbarCommentId);
	
	/*
	 * 查询获赞数
	 * by uId
	 */
	public int getPostbarCommentGoodCountByuId(Integer uId);
}
