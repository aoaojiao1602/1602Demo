package com.gzz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.entity.PostbarCommentGood;
import com.gzz.repository.PostbarCommentGoodRepository;
import com.gzz.service.PostbarCommentGoodService;

@Service
public class PostbarCommentGoodServiceImpl implements PostbarCommentGoodService {
	
	@Autowired
	private PostbarCommentGoodRepository postbarCommentGoodRepository;
	@Override
	public int putPostbarCommentGood(Integer postbarCommentGoodPostbarCommentId, Integer uId) {
		// TODO Auto-generated method stub
		return postbarCommentGoodRepository.putPostbarCommentGood(postbarCommentGoodPostbarCommentId, uId);
	}

	@Override
	public int deletePostbarCommentGood(Integer postbarCommentGoodPostbarCommentId, Integer uId) {
		// TODO Auto-generated method stub
		return postbarCommentGoodRepository.deletePostbarCommentGood(postbarCommentGoodPostbarCommentId, uId);
	}

	@Override
	public PostbarCommentGood getPostbarCommentGood(Integer postbarCommentGoodPostbarCommentId, Integer uId) {
		// TODO Auto-generated method stub
		return postbarCommentGoodRepository.getPostbarCommentGood(postbarCommentGoodPostbarCommentId, uId);
	}
	
	@Override
	public int getPostbarCommentGoodCountByPostbarComentId (Integer postbarCommentGoodPostbarCommentId) {
		// TODO Auto-generated method stub
		return postbarCommentGoodRepository.getPostbarCommentGoodCountByPostbarComentId(postbarCommentGoodPostbarCommentId);
	}
	
	@Override
	public int getPostbarCommentGoodCountByuId(Integer uId) {
		// TODO Auto-generated method stub
		return postbarCommentGoodRepository.getPostbarCommentGoodCountByuId(uId);
	}
}
