package com.gzz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.entity.PostbarReplyNotGood;
import com.gzz.repository.PostbarReplyNotGoodRepository;
import com.gzz.service.PostbarReplyNotGoodService;

@Service
public class PostbarReplyNotGoodServiceImpl implements PostbarReplyNotGoodService {
	
	@Autowired
	private PostbarReplyNotGoodRepository postbarReplyNotGoodRepository;
	@Override
	public int putPostbarReplyNotGood(Integer postbarReplyNotGoodPostbarReplyId, Integer uId) {
		// TODO Auto-generated method stub
		return postbarReplyNotGoodRepository.putPostbarReplyNotGood(postbarReplyNotGoodPostbarReplyId, uId);
	}

	@Override
	public int deletePostbarReplyNotGood(Integer postbarReplyNotGoodPostbarReplyId, Integer uId) {
		// TODO Auto-generated method stub
		return postbarReplyNotGoodRepository.deletePostbarReplyNotGood(postbarReplyNotGoodPostbarReplyId, uId);
	}

	@Override
	public PostbarReplyNotGood getPostbarReplyNotGood(Integer postbarReplyNotGoodPostbarReplyId, Integer uId) {
		// TODO Auto-generated method stub
		return postbarReplyNotGoodRepository.getPostbarReplyNotGood(postbarReplyNotGoodPostbarReplyId, uId);
	}
	
	@Override
	public int getPostbarReplyNotGoodCount (Integer postbarReplyNotGoodPostbarReplyId) {
		// TODO Auto-generated method stub
		return postbarReplyNotGoodRepository.getPostbarReplyNotGoodCount(postbarReplyNotGoodPostbarReplyId);
	}
}
