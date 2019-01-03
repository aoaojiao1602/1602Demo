package com.gzz.service;

import java.util.List;

import com.gzz.entity.PostbarCategory;

public interface PostbarCategoryService {
	
	/**
	 * 查询所有分类
	 * @return
	 */
	public List<PostbarCategory> getPostbarCategory();
}
