package com.hwg.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hwg.entity.Learnrecord;
import com.hwg.service.CourseService;
import com.hwg.service.YwzService;
import com.hwg.serviceImpl.BaomingServiceImpl;
import com.hwg.serviceImpl.LearnrecordServiceImpl;

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
	private YwzService cService;//雍文正接口
	
	@Autowired
	private CourseService csService;/*课程接口*/
	
	@Autowired
	private LearnrecordServiceImpl lrService;/*学习记录接口*/
	
	
	@Autowired
	private BaomingServiceImpl bService;	
	/**
	 * 	查询推荐课程（根据位置）
	 * @return
	 */
	@GetMapping("/getCourseTj")
	@ApiOperation("查询推荐课程（根据位置）")
	@ApiImplicitParam(value="推荐位置",name="position")
	public Object getCourseTj(String position) {
		//查询出当前位置的推荐课程
		List<Map<String, Object>> list=(List<Map<String, Object>>) cService.gettjCourse(position, "");
		//用于存储课程信息
		List<Map<String, Object>> listCourse=new ArrayList<>();
		//循环推荐课程
		for (Map<String, Object> mp : list) {
			//得到当前推荐课程id 调用查询课程信息方法 并添加到集合
			int cid=Integer.parseInt(mp.get("courseId").toString());
			Map<String, Object> map=new LinkedHashMap<>();
			map.putAll((Map<String, Object>) csService.getCourseById(cid));
			map.put("num", bService.findBaomingByCourseId(cid).size());
			listCourse.add(map);
		}
		return listCourse;
	}
	
	/**
	 * 	查询出指定课程信息
	 * @param cid
	 * @return
	 */
	@GetMapping("/getCourseById")
	public Object getCourseById(Integer cid) {
		Map<String, Object> rest=new HashMap<String, Object>();
		Map<String, Object> course=(Map<String, Object>) csService.getCourseById(cid);
		rest.putAll(course);
		rest.put("number", bService.findBaomingByCourseId(Integer.parseInt(course.get("courseId").toString())).size());
		return rest;
	}
	
	
	/**
	 * 根据分类查询课程
	 * @return
	 */
	@ApiOperation("根据分类查询课程")
	@GetMapping("getCourseByCategoryId")
	@ApiImplicitParams({@ApiImplicitParam(name="cId",value="分类id"),@ApiImplicitParam(name="access_token",value="用户token")})
	public Object getCourseByCategoryId(Integer cId,String access_token) {
		List<Map<String, Object>> listMap=(List<Map<String, Object>>) csService.getCourseByCategoryId(cId);
		List<Map<String, Object>> list=new ArrayList<>();
		for (Map<String, Object> thismap : listMap) {
			Map<String, Object> map=new HashMap<String, Object>();
			map.putAll(thismap);//将当前课程加入map
			//查询当前课程的报名记录
			map.put("number", bService.findBaomingByCourseId(Integer.parseInt(thismap.get("courseId").toString())).size());
			list.add(map);
		}
		return list;
	}
	
	/**
	 *	查询指定课程的所有章节
	 * @param cid
	 * @return
	 */
	@GetMapping("/getZhangjie")
	public Object getZhangjie(String cid) {
		return csService.getZhangjie(cid);
	}
	
	/**
	 * 查询指定章节下课时
	 * @return
	 */
	@GetMapping("getKeshi")
	public Object getKeshi(String zj,String cid,String uid) {
		List<Map<String, Object>> listMap=(List<Map<String, Object>>) csService.getKeshi(zj);
		List<Map<String, Object>> rest=new ArrayList<>();
		for (Map<String, Object> map : listMap) {
			Map<String, Object> restMap=new HashMap<>();
			Learnrecord lc=lrService.findlearnrecord(cid, uid, map.get("hourId").toString());
			if(lc!=null) {
				restMap.put("isxx", true);
			}else {
				restMap.put("isxx", false);
			}
			restMap.putAll(map);
			rest.add(restMap);
		}
		return rest;
	}
	
}
