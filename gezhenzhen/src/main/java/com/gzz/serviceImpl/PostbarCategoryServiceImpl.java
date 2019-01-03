package com.gzz.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.entity.PostbarCategory;
import com.gzz.repository.PostbarCategoryRepository;
import com.gzz.service.PostbarCategoryService;

@Service
public class PostbarCategoryServiceImpl implements PostbarCategoryService {
	
	@Autowired
	private PostbarCategoryRepository postbarCategoryRepository;
	@Override
	public List<PostbarCategory> getPostbarCategory() {
		// TODO Auto-generated method stub
		return postbarCategoryRepository.getPostbarCategory();
	}

}
