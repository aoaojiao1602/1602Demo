package com.gzz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gzz.entity.PostbarReply;
import com.gzz.repository.PostbarReplyRepository;
import com.gzz.service.PostbarReplyService;

@Service
public class PostbarReplyServiceImpl implements PostbarReplyService {
	
	@Autowired
	private PostbarReplyRepository postbarReplyRepository;
	
	/*
	 * 回复主贴
	 */
	@Override
	public int putPostbarReply(Integer uId, Integer postbarReplyPostbarId, String postbarReplyContent) {
		// TODO Auto-generated method stub
		return postbarReplyRepository.putPostbarReply(uId, postbarReplyPostbarId, postbarReplyContent);
	}
	
	/*
	 * 查询回复数
	 * By PostbarId
	 */
	@Override
	public int getPostbarReplyCountByPostbarId(Integer postbarReplyPostbarId) {
		// TODO Auto-generated method stub
		return postbarReplyRepository.getPostbarReplyCountByPostbarId(postbarReplyPostbarId);
	}
	
	/*
	 * 查询回复数
	 * By uId
	 */
	@Override
	public int getPostbarReplyCountByuId(Integer uId) {
		// TODO Auto-generated method stub
		return postbarReplyRepository.getPostbarReplyCountByuId(uId);
	}
	
	/*
	 * 查询最后回复的uId和时间
	 */
	@Override
	public PostbarReply getLastPostbarReply(Integer postbarReplyPostbarId) {
		// TODO Auto-generated method stub
		return postbarReplyRepository.getLastPostbarReply(postbarReplyPostbarId);
	}
	
	/*
	 * 删除自己发表的回复
	 */
	@Override
	public int deletePostbarReply(Integer uId,Integer postbarReplyId) {
		// TODO Auto-generated method stub
		return postbarReplyRepository.deletePostbarReply(uId, postbarReplyId);
	}
	
	/*
	 * 查询被回复数
	 */
	@Override
	public int getPostbarReplyedCountByuId(Integer uId) {
		return postbarReplyRepository.getPostbarReplyedCountByuId(uId);
	}
	
	@Override
	public Page<PostbarReply> getPostbarReplyPage(Integer page,Integer size){
		Sort sort = new Sort(Sort.Direction.ASC, "postbarReplyId"); 
	    Pageable pageable = new PageRequest(page, size, sort);
	    return postbarReplyRepository.findAll(pageable);
	}
	
	@Override
	public Page<PostbarReply> getPostbarReplyPageByPostbarReplyPostbarId(Integer postbarReplyPostbarId,Integer page,Integer size){
		Sort sort = new Sort(Sort.Direction.ASC, "postbar_reply_id"); 
	    Pageable pageable = new PageRequest(page, size, sort);
	    return postbarReplyRepository.getPostbarReplyPageByPostbarReplyPostbarId(postbarReplyPostbarId,pageable);
	}
	
	/**
	 * 个人中心回复分页
	 * @param uId
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<PostbarReply> getPostbarReplyPageByuId(Integer uId,Integer page,Integer size){
		Sort sort = new Sort(Sort.Direction.ASC, "postbar_reply_id"); 
	    Pageable pageable = new PageRequest(page, size, sort);
	    return postbarReplyRepository.getPostbarReplyPageByuId(uId,pageable);
	}
}
