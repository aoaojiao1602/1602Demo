package com.lhf.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhf.entity.Courseware;
import com.lhf.entity.CoursewareSearch;
import com.lhf.service.CoursewareService;

@RestController
@RequestMapping("/courseware")
public class CoursewareController {
	@Autowired
	private CoursewareService cwService;
	
	//章节添加
	@RequestMapping("/putCourseware")
	public Object putCourseware(Courseware cw) {
		int Cw=cwService.putCourseware(cw);
		Map<String, Object> map = new HashMap<>();
		if(Cw>0) {
			map.put("success",true);
			map.put("message","添加成功");
		}else {
			map.put("success",false);
			map.put("message","添加失败");
		}
		return Cw;
	}

	//章节删除
		@RequestMapping("/deleteCoursesware")
		public Object deleteCoursewareById(Integer cwId) {
			int Cw=cwService.deleteCoursewareById(cwId);
			Map<String, Object> map = new HashMap<>();
			if(Cw>0) {
				map.put("success",true);
				map.put("message","删除成功");
			}else {
				map.put("success",false);
				map.put("message","删除失败");
			}
			return Cw;
		}
		
		//章节修改
		//http://localhost:8050/courseware/postcoursewareById?hourCourse=金融&hourName=银行&hourParentId=13&hourId=6

		@RequestMapping("/postCoursewareById")
		public Object postCoursewareById(Courseware cw) {
			int Cw=cwService.postCoursewareById(cw);
			Map<String, Object> map = new HashMap<>();
			if(Cw>0) {
				map.put("success",true);
				map.put("message","修改成功");
			}else {
				map.put("success",false);
				map.put("message","修改失败");
			}
			return Cw;
		}
		
		//章节查询
		@RequestMapping("/query")
		public Object queryByDynamicwSQLPage(CoursewareSearch cwSearch,int page,int limit) {
			Page<Courseware> sqlPage = cwService.queryByDynamicwSQLPage(cwSearch, page-1, limit);
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("count", sqlPage.getTotalElements());
			map.put("data", sqlPage.getContent());
			return map;
		}
}
