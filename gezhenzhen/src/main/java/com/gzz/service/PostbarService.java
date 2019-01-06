package com.gzz.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gzz.entity.Postbar;

public interface PostbarService {
	
	/*
	 * 发布帖子
	 */
	public int putPostbar(Integer uId, String postbarTitle,String postbarContent);
	
	/*
	 * 修改本人发布的帖子
	 */
	public int postPostbar (String postbarTitle,String postbarContent, Integer postbarId, Integer uId);
	
	/*
	 * 查询主题数
	 */
	public int getPostbarTitleCount(Integer uId);
	
	/*
	 * 查询帖子主题
	 */
	public List<Postbar> getPostbarTitle(Integer uId);
	
	/*public Page<Postbar> getPostbar(Integer page,Integer size);*/
	
	/*
	 * 查询获赞数
	 * by uId
	 */
	public int getGoodCountByuId(Integer uId);
	
	/*
	 * 查询主贴内容
	 */
	public Postbar getPostbar(Integer postbarId);
	
	/*
	 * 首页精彩讨论
	 */
	public Postbar getHotPostbar();
	
	/**
	 * 个人中心主贴分页
	 * @param uId
	 * @param pageable
	 * @return
	 */
	public Page<Postbar> getPostbarPageByuId(Integer uId,Integer page,Integer size);
	
	public Page<Postbar> findAll(String postbarCreateTime,Integer page,Integer size);
}
