package com.hwg.service;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description 分类业务接口 利用feign调用外部接口
 * @author HJiong
 * @time 2018年12月14日 下午1:56:32
 */
@FeignClient("yongwenzheng")
public interface CategoryService {

	/**
	 * 	查询出所有的类别信息 
	 * @return
	 */
	@RequestMapping("navigation/getALLNavigationList")
	public List<Map<String, Object>> getCategoryAll(@RequestParam("access_token") String access_token);
}
