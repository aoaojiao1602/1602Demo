package com.gzz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.repository.PostbarNotGoodRepository;
import com.gzz.service.PostbarNotGoodService;
import com.gzz.entity.PostbarNotGood;

@Service
public class PostbarNotGoodServiceImpl implements PostbarNotGoodService {
	
	@Autowired
	private PostbarNotGoodRepository postbarNotGoodRepository;
	@Override
	public int putPostbarNotGood(Integer postbarNotGoodPostbarId,Integer uId) {
		// TODO Auto-generated method stub
		return postbarNotGoodRepository.putPostbarNotGood(postbarNotGoodPostbarId, uId);
	}

	@Override
	public int deletePostbarNotGood(Integer postbarNotGoodPostbarId,Integer uId) {
		// TODO Auto-generated method stub
		return postbarNotGoodRepository.deletePostbarNotGood(postbarNotGoodPostbarId, uId);
	}

	@Override
	public PostbarNotGood getPostbarNotGood(Integer postbarNotGoodPostbarId,Integer uId) {
		// TODO Auto-generated method stub
		return postbarNotGoodRepository.getPostbarNotGood(postbarNotGoodPostbarId, uId);
	}
	
	@Override
	public int getPostbarNotGoodCount (Integer postbarNotGoodPostbarId) {
		// TODO Auto-generated method stub
		return postbarNotGoodRepository.getPostbarNotGoodCount(postbarNotGoodPostbarId);
	}
}
