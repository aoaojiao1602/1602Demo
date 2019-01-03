package com.gzz.service;

import com.gzz.entity.PostbarCommentNotGood;

public interface PostbarCommentNotGoodService {
	
	/*
	 * 评论踩贴
	 */
	public int putPostbarCommentNotGood (Integer postbarCommentNotGoodPostbarCommentId,Integer uId);
	
	/*
	 * 评论取消踩贴
	 */
	public int deletePostbarCommentNotGood (Integer postbarCommentNotGoodPostbarCommentId,Integer uId);
	
	/*
	 * 查询用户是否对评论已经踩帖
	 */
	public PostbarCommentNotGood getPostbarCommentNotGood (Integer postbarCommentNotGoodPostbarCommentId,Integer uId);
	
}
