package com.lhf.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhf.entity.Courseware;
import com.lhf.entity.CoursewareSearch;
import com.lhf.entity.Hours;
import com.lhf.entity.HoursSearch;
import com.lhf.service.HoursService;

@RestController
@RequestMapping("/hours")
public class HoursController {

	
	@Autowired
	private HoursService hService;
	
	//课时添加
	//http://localhost:8050/hours/puthours?hourCourse=计算机&&hourParentId=1&&hourName=写项目
		@RequestMapping("/puthours")
		public Object putHours(Hours h) {
			int H=hService.putHours(h);
			Map<String, Object> map = new HashMap<>();
			if(H>0) {
				map.put("success",true);
				map.put("message","添加成功");
			}else {
				map.put("success",false);
				map.put("message","添加失败");
			}
			return H;
		}
		
		//课时删除
		//http://localhost:8050/hours/deletehoursById?hourId=10
		@RequestMapping("/deletehoursById")
		public Object deleteHoursById(Integer hourId) {
			int H=hService.deleteHoursById(hourId);
			Map<String, Object> map = new HashMap<>();
			if(H>0) {
				map.put("success",true);
				map.put("message","删除成功");
			}else {
				map.put("success",false);
				map.put("message","删除失败");
			}
			return H;
		}
		
		//课时修改
		//http://localhost:8050/hours/posthoursById?hourCourse=金融&hourName=银行&hourParentId=13&hourId=6
		@RequestMapping("/posthoursById")
		public Object postHoursById(Hours h) {
			int H=hService.postHoursById(h);
			Map<String, Object> map = new HashMap<>();
			if(H>0) {
				map.put("success",true);
				map.put("message","修改成功");
			}else {
				map.put("success",false);
				map.put("message","修改失败");
			}
			return H;
		}
		
		//章节查询
		//http://localhost:8050/hours/query?page=1&limit=3
				@RequestMapping("/query")
				public Object queryByDyHoursSQLPage(HoursSearch HSearch, Integer page, Integer size,int limit){
					Page<Hours> sqlPage = hService.queryByDyHoursSQLPage(HSearch, page-1, limit);
					Map<String, Object> map=new HashMap<String, Object>();
					map.put("count", sqlPage.getTotalElements());
					map.put("data", sqlPage.getContent());
					return map;
				}
}
