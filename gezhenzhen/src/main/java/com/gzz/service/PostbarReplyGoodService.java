package com.gzz.service;

import com.gzz.entity.PostbarReplyGood;

public interface PostbarReplyGoodService {
	
	/*
	 * 回复顶贴
	 */
	public int putPostbarReplyGood (Integer postbarReplyGoodPostbarReplyId,Integer uId);
	
	/*
	 * 回复取消顶贴
	 */
	public int deletePostbarReplyGood (Integer postbarReplyGoodPostbarReplyId,Integer uId);
	
	/*
	 * 查询用户是否对回复已经点过赞
	 */
	public PostbarReplyGood getPostbarReplyGood (Integer postbarReplyGoodPostbarReplyId,Integer uId);
	
	/*
	 * 查询点赞数
	 * by PostbarReplyId
	 */
	public int getPostbarReplyGoodCountByPostbarReplyId (Integer postbarReplyGoodPostbarReplyId);
	
	/*
	 * 查询获赞数
	 * by uId
	 */
	public int getPostbarReplyGoodCountByuId(Integer uId);
}
