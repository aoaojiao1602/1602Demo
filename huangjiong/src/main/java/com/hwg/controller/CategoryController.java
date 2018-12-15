package com.hwg.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 分类控制器层
 * @author HJiong
 * @time 2018年12月15日 上午12:25:50
 */
@RestController
public class CategoryController {
	
	/**
	 * 	查询出所有的分类
	 * @return
	 */
	@GetMapping("category")
	@CrossOrigin
	public Object getCategoryAll() {
		List<String> list=new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");
		list.add("9");
		list.add("10");
		list.add("11");
		return list;
	}

}
