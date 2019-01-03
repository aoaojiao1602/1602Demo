package com.gzz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gzz.entity.PostbarComment;
import com.gzz.repository.PostbarCommentRepository;
import com.gzz.service.PostbarCommentService;

@Service
public class PostbarCommentServiceImpl implements PostbarCommentService {
	
	@Autowired
	private PostbarCommentRepository postbarCommentRepository;
	@Override
	public int putPostbarComment(Integer uId, Integer postbarCommentPostbarReplyId, String postbarCommentContent) {
		// TODO Auto-generated method stub
		return postbarCommentRepository.putPostbarComment(uId, postbarCommentPostbarReplyId, postbarCommentContent);
	}

	@Override
	public int getPostbarCommentCountByPostbarReplyId(Integer postbarCommentPostbarReplyId) {
		// TODO Auto-generated method stub
		return postbarCommentRepository.getPostbarCommentCountByPostbarReplyId(postbarCommentPostbarReplyId);
	}

	@Override
	public int getPostbarCommentCountByuId(Integer uId) {
		// TODO Auto-generated method stub
		return postbarCommentRepository.getPostbarCommentCountByuId(uId);
	}
	
	@Override
	public int deletePostbarComment(Integer postbarCommentId,Integer uId) {
		// TODO Auto-generated method stub
		return postbarCommentRepository.deletePostbarComment(postbarCommentId, uId);
	}
	
	@Override
	public int deletePostbarCommentByPostbarCommentPostbarReplyId(Integer postbarCommentPostbarReplyId) {
		// TODO Auto-generated method stub
		return postbarCommentRepository.deletePostbarCommentByPostbarCommentPostbarReplyId(postbarCommentPostbarReplyId);
	}
	
	/*
	 * 查询被评论数
	 */
	@Override
	public int getPostbarCommentedCountByuId(Integer uId) {
		// TODO Auto-generated method stub
		return postbarCommentRepository.getPostbarCommentedCountByuId(uId);
	}
	
	/**
	 * 个人中心评论分页
	 * @param uId
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<PostbarComment> getPostbarCommentPageByuId(Integer uId,Integer page,Integer size){
		Sort sort = new Sort(Sort.Direction.ASC, "postbar_comment_id"); 
	    Pageable pageable = new PageRequest(page, size, sort);
	    return postbarCommentRepository.getPostbarCommentPageByuId(uId,pageable);
	}
	
	/**
	 * 评论分页
	 * @param postbarCommentPostbarReplyId
	 * @param pageable
	 * @return
	 */
	@Override
	public Page<PostbarComment> getPostbarCommentPageByPostbarCommentPostbarReplyId(Integer postbarCommentPostbarReplyId,Integer page,Integer size){
		Sort sort = new Sort(Sort.Direction.ASC, "postbar_comment_id"); 
	    Pageable pageable = new PageRequest(page, size, sort);
	    return postbarCommentRepository.getPostbarCommentPageByPostbarCommentPostbarReplyId(postbarCommentPostbarReplyId,pageable);
	}
}
