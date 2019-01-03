package com.gzz.service;

import com.gzz.entity.PostbarGood;

public interface PostbarGoodService {
	
	/*
	 * 贴吧顶贴
	 */
	public int putPostbarGood (Integer postbarGoodPostbarId,Integer uId);
	
	/*
	 * 贴吧取消顶贴
	 */
	public int deletePostbarGood (Integer postbarGoodPostbarId,Integer uId);
	
	/*
	 * 查询用户是否对帖子已经点过赞
	 */
	public PostbarGood getPostbarGood (Integer postbarGoodPostbarId,Integer uId);
	
	/*
	 * 查询点赞数
	 * by PostbarId
	 */
	public int getPostbarGoodCountByPostbarId (Integer postbarGoodPostbarId);
	
	/*
	 * 查询获赞数
	 * by uId
	 */
	public int getPostbarGoodCountByuId(Integer uId);
}
