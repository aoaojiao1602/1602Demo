package com.hwg.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hwg.service.YwzService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @Description 课程控制器层
 * @author HJiong
 * @time 2018年12月17日 下午3:22:46
 */
@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private YwzService cService;
	
	
	/**
	 * 	查询推荐课程（根据位置）
	 * @return
	 */
	@GetMapping("/getCourseTj")
	@ApiOperation("查询推荐课程（根据位置）")
	@ApiImplicitParam(value="推荐位置",name="position")
	public Object getCourseTj(String position) {
	/*	List<Map<String, Object>> list=new ArrayList<>();
		
		for (int i = 1; i<=8; i++) {
			Map<String, Object> map=new HashMap<String,Object>();
			map.put("url", "");
			map.put("courseName", "ms第"+i+"讲");
			map.put("zj", "进行至一周");
			map.put("gs", "讲述ms传奇的人生经历 助你走上人生巅峰早日能与太阳肩并肩");
			list.add(map);
		}*/
		List<Map<String, Object>> list=(List<Map<String, Object>>) cService.gettjCourse(position, "");
		for (Map<String, Object> map : list) {
			//调用查询课程方法
		}
		//System.out.println(cService.gettjCourse(position, "").getClass());
		return cService.gettjCourse(position, "");
	}
	
	
	/**
	 * 根据分类查询课程
	 * @return
	 */
	@ApiOperation("根据分类查询课程")
	@GetMapping("getCourseByCategoryId")
	@ApiImplicitParams({@ApiImplicitParam(name="cId",value="分类id"),@ApiImplicitParam(name="access_token",value="用户token")})
	public Object getCourseByCategoryId(Integer cId,String access_token) {
		List<String> list=new ArrayList<>();
	
		return list;
	}

}
