package com.gzz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.gzz.entity.PostbarReply;

public interface PostbarReplyService {
	
	/*
	 * 回复主贴
	 */
	public int putPostbarReply(Integer uId, Integer postbarReplyPostbarId,String postbarReplyContent);
	
	/*
	 * 查询回复数
	 * By PostbarId
	 */
	public int getPostbarReplyCountByPostbarId(Integer postbarReplyPostbarId);
	
	/*
	 * 查询回复数
	 * By uId
	 */
	public int getPostbarReplyCountByuId(Integer uId);
	
	/*
	 * 查询最后回复的uId和时间
	 */
	public PostbarReply getLastPostbarReply(Integer postbarReplyPostbarId);
	
	/*
	 * 删除自己发表的回复
	 */
	public int deletePostbarReply(Integer uId,Integer postbarReplyId);
	
	/*
	 * 查询被回复数
	 */
	public int getPostbarReplyedCountByuId(Integer uId);
	
	public Page<PostbarReply> getPostbarReplyPage(Integer page,Integer size);
	
	/**
	 * 回复分页
	 * @param postbarReplyPostbarId
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<PostbarReply> getPostbarReplyPageByPostbarReplyPostbarId(Integer postbarReplyPostbarId,Integer page,Integer size);
	
	/**
	 * 个人中心回复分页
	 * @param uId
	 * @param pageable
	 * @return
	 */
	public Page<PostbarReply> getPostbarReplyPageByuId(Integer uId,Integer page,Integer size); 
}
