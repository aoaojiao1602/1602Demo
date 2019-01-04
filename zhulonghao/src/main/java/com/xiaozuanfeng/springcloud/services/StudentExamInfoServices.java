package com.xiaozuanfeng.springcloud.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("liuwenjin")
public interface StudentExamInfoServices {
	@RequestMapping("/queryStudentExaminfoByStuid")
	public Object queryStudentExaminfoByStuid(@RequestParam("stuid")int stuid);
}
