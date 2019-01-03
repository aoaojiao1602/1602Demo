package com.gzz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.entity.PostbarReplyGood;
import com.gzz.repository.PostbarReplyGoodRepository;
import com.gzz.service.PostbarReplyGoodService;

@Service
public class PostbarReplyGoodServiceImpl implements PostbarReplyGoodService {
	
	@Autowired
	private PostbarReplyGoodRepository postbarReplyGoodRepository;
	
	@Override
	public int putPostbarReplyGood(Integer postbarReplyGoodPostbarReplyId, Integer uId) {
		// TODO Auto-generated method stub
		return postbarReplyGoodRepository.putPostbarReplyGood(postbarReplyGoodPostbarReplyId, uId);
	}

	@Override
	public int deletePostbarReplyGood(Integer postbarReplyGoodPostbarReplyId, Integer uId) {
		// TODO Auto-generated method stub
		return postbarReplyGoodRepository.deletePostbarReplyGood(postbarReplyGoodPostbarReplyId, uId);
	}

	@Override
	public PostbarReplyGood getPostbarReplyGood(Integer postbarReplyGoodPostbarReplyId, Integer uId) {
		// TODO Auto-generated method stub
		return postbarReplyGoodRepository.getPostbarReplyGood(postbarReplyGoodPostbarReplyId, uId);
	}
	
	@Override
	public int getPostbarReplyGoodCountByPostbarReplyId (Integer postbarReplyGoodPostbarReplyId) {
		// TODO Auto-generated method stub
		return postbarReplyGoodRepository.getPostbarReplyGoodCountByPostbarReplyId(postbarReplyGoodPostbarReplyId);
	}
	
	@Override
	public int getPostbarReplyGoodCountByuId(Integer uId) {
		// TODO Auto-generated method stub
		return postbarReplyGoodRepository.getPostbarReplyGoodCountByuId(uId);
	}
}
