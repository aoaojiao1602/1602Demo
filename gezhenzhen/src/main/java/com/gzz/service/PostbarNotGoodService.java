package com.gzz.service;

import com.gzz.entity.PostbarNotGood;

public interface PostbarNotGoodService {
	
	/*
	 * 贴吧踩贴
	 */
	public int putPostbarNotGood (Integer postbarNotGoodPostbarId,Integer uId);
	
	/*
	 * 贴吧取消踩贴
	 */
	public int deletePostbarNotGood (Integer postbarNotGoodPostbarId,Integer uId);
	
	/*
	 * 查询用户是否对帖子已经踩贴
	 */
	public PostbarNotGood getPostbarNotGood (Integer postbarNotGoodPostbarId,Integer uId);
	
	/*
	 * 查询踩帖数
	 */
	public int getPostbarNotGoodCount (Integer postbarNotGoodPostbarId);
}
