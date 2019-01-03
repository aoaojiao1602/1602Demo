package com.gzz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.entity.PostbarGood;
import com.gzz.repository.PostbarGoodRepository;
import com.gzz.service.PostbarGoodService;

@Service
public class PostbarGoodServiceImpl implements PostbarGoodService {
	
	@Autowired
	private PostbarGoodRepository postbarGoodRepository;
	
	@Override
	public int putPostbarGood(Integer postbarGoodPostbarId,Integer uId) {
		// TODO Auto-generated method stub
		return postbarGoodRepository.putPostbarGood(postbarGoodPostbarId, uId);
	}

	@Override
	public int deletePostbarGood(Integer postbarGoodPostbarId,Integer uId) {
		// TODO Auto-generated method stub
		return postbarGoodRepository.deletePostbarGood(postbarGoodPostbarId, uId);
	}
	
	@Override
	public PostbarGood getPostbarGood(Integer postbarGoodPostbarId,Integer uId) {
		// TODO Auto-generated method stub
		return postbarGoodRepository.getPostbarGood(postbarGoodPostbarId, uId);
	}
	
	@Override
	public int getPostbarGoodCountByPostbarId (Integer postbarGoodPostbarId) {
		// TODO Auto-generated method stub
		return postbarGoodRepository.getPostbarGoodCountByPostbarId(postbarGoodPostbarId);
	}
	
	@Override
	public int getPostbarGoodCountByuId(Integer uId) {
		// TODO Auto-generated method stub
		return postbarGoodRepository.getPostbarGoodCountByuId(uId);
	}
}
