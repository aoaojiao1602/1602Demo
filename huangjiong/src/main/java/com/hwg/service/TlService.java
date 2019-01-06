package com.hwg.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 讨论接口 调用精彩讨论子项目
 * @author HJiong
 * @time 2019年1月6日 上午9:15:03
 */
@FeignClient("gezhenzhen")
public interface TlService {
	/**
	 * 查询指定讨论信息
	 * @return
	 */
	@RequestMapping("")
	public Object getJctl();

}
