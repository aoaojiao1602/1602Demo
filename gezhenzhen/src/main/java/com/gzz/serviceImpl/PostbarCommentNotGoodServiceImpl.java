package com.gzz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.entity.PostbarCommentNotGood;
import com.gzz.repository.PostbarCommentNotGoodRepository;
import com.gzz.service.PostbarCommentNotGoodService;

@Service
public class PostbarCommentNotGoodServiceImpl implements PostbarCommentNotGoodService {
	
	@Autowired
	private PostbarCommentNotGoodRepository postbarCommentNotGoodRepository;
	@Override
	public int putPostbarCommentNotGood(Integer postbarCommentNotGoodPostbarCommentId, Integer uId) {
		// TODO Auto-generated method stub
		return postbarCommentNotGoodRepository.putPostbarCommentNotGood(postbarCommentNotGoodPostbarCommentId, uId);
	}

	@Override
	public int deletePostbarCommentNotGood(Integer postbarCommentNotGoodPostbarCommentId, Integer uId) {
		// TODO Auto-generated method stub
		return postbarCommentNotGoodRepository.deletePostbarCommentNotGood(postbarCommentNotGoodPostbarCommentId, uId);
	}

	@Override
	public PostbarCommentNotGood getPostbarCommentNotGood(Integer postbarCommentNotGoodPostbarCommentId, Integer uId) {
		// TODO Auto-generated method stub
		return postbarCommentNotGoodRepository.getPostbarCommentNotGood(postbarCommentNotGoodPostbarCommentId, uId);
	}

}
