package com.lhf.controller;




import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhf.entity.Courses;
import com.lhf.entity.CoursesSearch;
import com.lhf.service.CoursesService;
@CrossOrigin
@RestController
@RequestMapping("/courses")
public class CoursesController {
	@Autowired
	private CoursesService cService;
	/**查询方法
	 * localhost:8050/courses/query?page=1&limit=2
	 * @param c 实体类课程
	 * @param page 页码
	 * @param limit 条数
	 * @return
	 */
	@RequestMapping("/query")
	public Object queryByDynamicSQLPage(CoursesSearch c,int page,int limit) {
		Page<Courses> sqlPage = cService.queryByDynamicSQLPage(c, page-1, limit);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("count", sqlPage.getTotalElements());
		map.put("data", sqlPage.getContent());
		return map;
	}
	/*@RequestMapping("/query")
	public Object queryNameLikeAllPage(String name,Integer page,Integer size) {
		if (name==null||name==""||name.isEmpty()||name.equals("")) {
			name="%";
		}
		Page<Courses> page1 = null;
		page1 = cService.queryNameLikeAllPage(name,page==0?1:page-1,1);
    	List<Courses> list = page1.getContent();
		Long total = page1.getTotalElements();
    	Map<String, Object> map = new HashMap<>();
    	map.put("total", total);
    	map.put("rows", list);
    	return map;
	}*/
	
	/**
	 * 添加方法
	 * http://localhost:8050/courses/putCourses?courseName=诗经&courseCategory=国学经典&courseCreator=李四
	 * @param c 实体类课程
	 * @return
	 */
	@RequestMapping("/putCourses")
	public Object putCourses(Courses c) {
		int C=cService.putCourses(c);
		Map<String, Object> map = new HashMap<>();
		if(C>0) {
			map.put("success",true);
			map.put("message","添加成功");
		}else {
			map.put("success",false);
			map.put("message","添加失败");
		}
		return C;
	}
	//删除
	/**
	 * 删除方法
	 * http://localhost:8050/courses/deleteCourses?courseId=5
	 * @param courseId 课程Id
	 * @return
	 */
	@RequestMapping("/deleteCourses")
	public Object deleteCoursesById(Integer courseId) {
		int C=cService.deleteCoursesById(courseId);
		Map<String, Object> map = new HashMap<>();
		if(C>0) {
			map.put("success",true);
			map.put("message","删除成功");
		}else {
			map.put("success",false);
			map.put("message","删除失败");
		}
		return C;
	}
	/**
	 * 修改方法
	 * http://localhost:8050/courses/postCourses?courseCategory=aaa&courseName=aaaaa&courseId=6
	 * @param c 实体类课程
	 * @return
	 */
	@RequestMapping("/postCourses")
	public Object postCoursesById(Courses c) {
		int C=cService.postCoursesById(c);
		Map<String, Object> map = new HashMap<>();
		if(C>0) {
			map.put("success",true);
			map.put("message","修改成功");
		}else {
			map.put("success",false);
			map.put("message","修改失败");
		}
		return C;
	}

}
