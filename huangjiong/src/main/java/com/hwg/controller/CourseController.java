package com.hwg.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 课程控制器层
 * @author HJiong
 * @time 2018年12月17日 下午3:22:46
 */
@RestController
public class CourseController {
	
	/**
	 * 	查询推荐课程
	 * @return
	 */
	@GetMapping("course")
	@CrossOrigin
	public Object getCourseTj() {
		List<Map<String, Object>> list=new ArrayList<>();
		
		for (int i = 1; i<=8; i++) {
			Map<String, Object> map=new HashMap<String,Object>();
			map.put("url", "");
			map.put("courseName", "ms第"+i+"讲");
			map.put("zj", "进行至一周");
			map.put("gs", "讲述ms传奇的人生经历 助你走上人生巅峰早日能与太阳肩并肩");
			list.add(map);
		}
		return list;
	}

}
