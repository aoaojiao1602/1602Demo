package com.hwg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hwg.entity.Sensitive;
import com.hwg.serviceImpl.SensitiveServiceImpl;

/**
 * @Description 敏感词controller
 * @author HJiong
 * @time 2019年1月4日 上午11:08:09
 */
@RestController
@RequestMapping("sensitive")
public class SensitiveController {
	
	@Autowired
	private SensitiveServiceImpl sService;
	
	/**
	 * 添加
	 * @return
	 */
	@PostMapping()
	public Object add(Sensitive model) {
		return sService.addSensitive(model);
	}
	
	/**
	 *	查询所有
	 * @return
	 */
	@GetMapping()
	public List<Sensitive> getAll(){
		return sService.getAll();
	}
	
	
	/**
	 * 删除敏感词汇
	 * @return
	 */
	@DeleteMapping()
	public Object deleteThis(Sensitive entity) {
		try {
			sService.delete(entity);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
