package com.gzz.service;

import com.gzz.entity.PostbarReplyNotGood;

public interface PostbarReplyNotGoodService {
	
	/*
	 * 回复踩贴
	 */
	public int putPostbarReplyNotGood (Integer postbarReplyNotGoodPostbarReplyId,Integer uId);
	
	/*
	 * 回复取消踩贴
	 */
	public int deletePostbarReplyNotGood (Integer postbarReplyNotGoodPostbarReplyId,Integer uId);
	
	/*
	 * 查询用户是否对回复已经踩帖
	 */
	public PostbarReplyNotGood getPostbarReplyNotGood (Integer postbarReplyNotGoodPostbarReplyId,Integer uId);
	
	/*
	 * 查询踩帖数
	 */
	public int getPostbarReplyNotGoodCount (Integer postbarReplyNotGoodPostbarReplyId);
}
