package com.lwj.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwj.springcloud.entity.Examinfo;
import com.lwj.springcloud.service.ExaminfoService;

@RestController
public class ExaminfoController {
	@Autowired
	private ExaminfoService eService;
	/**
	 * 添加考试
	 * @param examinfo
	 * @return
	 */
	@RequestMapping("/insertExaminfo")
	public Examinfo insertExaminfo(Examinfo examinfo) {
		return eService.insertExaminfo(examinfo);
	}
	/**
	 * 删除考试
	 * @param exId
	 * @return
	 */
	@RequestMapping("/deleteExaminfo")
	public int deleteExaminfo(Integer exId) {
		return eService.deleteExaminfo(exId);
	}
}
