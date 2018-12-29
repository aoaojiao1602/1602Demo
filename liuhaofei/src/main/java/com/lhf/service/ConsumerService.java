package com.lhf.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("yongwenzheng")
public interface ConsumerService {
	@RequestMapping("/navigation/getALLNavigationList")
	public Object queryNavigation(@RequestParam("access_token")String access_token);

}
