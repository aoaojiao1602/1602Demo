package com.hwg.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description 调用朱龙豪组服务接口
 * @author HJiong
 * @time 2019年1月3日 上午12:36:10
 */
@FeignClient("ZHULONGHAO")
public interface UserService {
	
	/**
	 * 查询出用户信息
	 * @return
	 */
	@RequestMapping("user/userinfo")
	public Object queryUser (@RequestParam("uid")Integer uid);
}
