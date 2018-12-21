package com.lhf.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhf.entity.Pic;
import com.lhf.entity.PicSearch;
import com.lhf.service.PicService;

@RestController
@RequestMapping("/pic")
public class PicController {
	@Autowired
	private PicService pService;
	//查询方法
		//http://http://localhost:8050/pic/query?page=1&&limit=2
		@RequestMapping("/query")
		public Object queryByDynamicSQLPage(PicSearch p,int page,int limit) {
			Page<Pic> sqlPage = pService.queryByDynamicSQLPage(p, page-1, limit);
			Map<String, Object> map=new HashMap<String, Object>();
			map.put("count", sqlPage.getTotalElements());
			map.put("data", sqlPage.getContent());
			return map;
		}
		//添加
		//http://localhost:8050/pic/putPic?picCourse=计算机&&picUrl=5.jpg
		@RequestMapping("/putPic")
		public Object putPic(Pic p){
			int N=pService.putPic(p);
			Map<String, Object> map = new HashMap<>();
			if(N>0) {
				map.put("success",true);
				map.put("message","添加成功");
			}else {
				map.put("success",false);
				map.put("message","添加失败");
			}
			return N;
			
		}
		//删除公告
		@RequestMapping("/deletePic")
		public Object deletePicByid(Integer picId) {
			int N=pService.deletePicByid(picId);
			Map<String, Object> map = new HashMap<>();
			if(N>0) {
				map.put("success",true);
				map.put("message","删除成功");
			}else {
				map.put("success",false);
				map.put("message","删除失败");
			}
			return N;
			
		}
		//修改
		//http://localhost:8050/pic/postPic?picCourse=计算机&&picUrl=6.jpg&&picId=1
		@RequestMapping("/postPic")
		public Object postNotice(Pic p) {
			int N=pService.postPic(p);
			Map<String, Object> map = new HashMap<>();
			if(N>0) {
				map.put("success",true);
				map.put("message","修改成功");
			}else {
				map.put("success",false);
				map.put("message","修改失败");
			}
			return N;
		}
}
