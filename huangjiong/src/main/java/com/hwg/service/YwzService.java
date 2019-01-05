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
public interface YwzService {

	/**
	 * 	查询出所有的类别信息 
	 * @return
	 */
	@RequestMapping("navigation/getALLNavigationList")
	public List<Map<String, Object>> getCategoryAll(@RequestParam("access_token") String access_token);
	
	/**
	 * 根据位置查询出推荐的课程
	 * @param position
	 * @param access_token
	 * @return
	 */
	@RequestMapping("course/getCourseByPositionId")
	public Object gettjCourse(@RequestParam("positionId")String position, @RequestParam("access_token") String access_token);
	
	
	/**
	 * 	通过位置查询精彩讨论
	 * @param position
	 * @param access_token
	 * @return
	 */
	@RequestMapping("discusscourse/getDiscusscourseByPositionId")
	public Object getjctl(@RequestParam("positionId")Integer position, @RequestParam("access_token") String access_token);
}
