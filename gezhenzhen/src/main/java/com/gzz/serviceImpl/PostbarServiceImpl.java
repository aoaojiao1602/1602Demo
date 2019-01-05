package com.gzz.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gzz.entity.Postbar;
import com.gzz.repository.PostbarRepository;
import com.gzz.service.PostbarService;

@Service
public class PostbarServiceImpl implements PostbarService {
	
	@Autowired
	private PostbarRepository postbarRepository;
	
	@Override
	public int putPostbar(Integer uId, String postbarTitle,String postbarContent) {
		return postbarRepository.putPostbar(uId, postbarTitle, postbarContent);
	}
	
	@Override
	public int postPostbar (String postbarTitle, String postbarContent, Integer postbarId, Integer uId) {
		return postbarRepository.postPostbar(postbarTitle, postbarContent, postbarId, uId);
	}
	
	/*
	 * 查询主题数
	 */
	@Override
	public int getPostbarTitleCount(Integer uId) {
		return postbarRepository.getPostbarTitleCount(uId);
	}
	
	/*
	 * 查询帖子主题
	 */
	@Override
	public List<Postbar> getPostbarTitle(Integer uId) {
		return postbarRepository.getPostbarTitle(uId);
	}
	
	/*@Override
	public Page<Postbar> getPostbar(Integer page,Integer size){
		Sort sort = new Sort(Sort.Direction.DESC, "postbarId"); 
	    Pageable pageable = new PageRequest(page, size, sort);
	    return postbarRepository.findAll(pageable);
	}*/
	
	@Override
	public int getGoodCountByuId(Integer uId) {
		return postbarRepository.getGoodCountByuId(uId);
	}
	
	/*
	 * 查询主贴内容
	 */
	@Override
	public Postbar getPostbar(Integer postbarId) {
		return postbarRepository.getPostbar(postbarId);
	}
	
	/*
	 * 首页精彩讨论
	 */
	@Override
	public Postbar getHotPostbar() {
		return postbarRepository.getHotPostbar();
	}
	
	/**
	 * 个人中心主贴分页
	 * @param uId
	 * @param pageable
	 * @return
	 */
	public Page<Postbar> getPostbarPageByuId(Integer uId,Integer page,Integer size){
		Sort sort = new Sort(Sort.Direction.ASC, "postbar_id"); 
	    Pageable pageable = new PageRequest(page, size, sort);
	    return postbarRepository.getPostbarPageByuId(uId,pageable);
	}
	
	public Page<Postbar> findAll(Integer page,Integer size){
		Sort sort = new Sort(Sort.Direction.DESC, "postbarId"); 
	    Pageable pageable = new PageRequest(page, size, sort);
	    return postbarRepository.findAll(pageable);
	}
}
