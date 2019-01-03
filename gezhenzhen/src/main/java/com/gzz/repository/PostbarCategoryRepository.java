package com.gzz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gzz.entity.PostbarCategory;

public interface PostbarCategoryRepository extends JpaRepository<PostbarCategory, Integer> {
	
	/**
	 * 查询所有分类
	 * @return
	 */
	@Query(value="SELECT * FROM postbar_categorytb", nativeQuery=true)
	public List<PostbarCategory> getPostbarCategory();
}
