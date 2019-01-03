package com.gzz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.entity.PostbarCategory;
import com.gzz.service.PostbarCategoryService;

@RestController
@RequestMapping("/postbarCategory")
public class PostbarCategoryController {
	
	@Autowired
	private PostbarCategoryService postbarCategoryService;
	
	/**
	 * http://localhost:8021/postbarCategory/getPosstbarCategory
	 * @return
	 */
	@RequestMapping("/getPosstbarCategory")
	public List<PostbarCategory> getPosstbarCategory(){
		return postbarCategoryService.getPostbarCategory();
	}
}
