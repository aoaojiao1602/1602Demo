package com.ysd.boot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.boot.entity.Module;
import com.ysd.boot.service.ModuleService;

@CrossOrigin
@RestController
@RequestMapping("/module")
public class ModuleController {
	
	@Autowired
	private ModuleService moduleService;

	/**
	 * TreeGrid 查询
	 * 可通过模块名称查询
	 * 在模块页面调用此方法
	 *  http://localhost:8006/module/queryTreeGrid?name=
	 * @return
	 */
	
	@RequestMapping(value="/queryTreeGrid",method=RequestMethod.GET)
	public Object queryTreeGrid(String name,String access_token) {
		
    
    	return moduleService.queryTreeGrid(name);
	}
	
	
	/***
	 * 添加模块
	 * http://localhost:8006/module/insertModule?mName=1&mUrl=1&mWeight=1&pid=0
	 * @param mName
	 * @param mUrl
	 * @param mWeight
	 * @param pid
	 * @return
	 */
	@RequestMapping(value="/insertModule",method=RequestMethod.PUT)
	public Object insertModule(String mName,String mUrl,Integer mWeight,Integer pid,String access_token) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		String ModuleName =moduleService.getMoudleByName(mName);
		if (ModuleName != null && !"".equals(ModuleName)) {
			map.put("success", false);
			map.put("message", "模块名称不能重复,添加失败");
		} else {
			int role = moduleService.insertMoudle(mName, mUrl, mWeight, pid);
			if (role > 0) {
				map.put("success", true);
				map.put("message", "添加成功");
			} else {
				map.put("success", false);
				map.put("message", "添加失败");
			}

		}
		return map;
	}
			
	
	
	
	/***
	 * 修改模块
	 * http://localhost:8006/module/updateModule?mid=11&mName=1&mUrl=1&mWeight=1
	 * @param mid
	 * @param mName
	 * @param mUrl
	 * @param mWeight
	 * @param pid
	 * @param upDate
	 * @return
	 */
	@RequestMapping(value="/updateModule",method=RequestMethod.POST)
	public Object updateModule(Integer mid,String mName,String mUrl,Integer mWeight,String access_token) {
		Map<String, Object> map = new HashMap<String, Object>();
		String ModuleName =moduleService.getMoudleByName(mName);
		if (ModuleName != null && !"".equals(ModuleName)) {
			map.put("success", false);
			map.put("message", "模块名称不能重复,修改失败");
		} else {
			int role = moduleService.updateMoudle(mid, mName, mUrl, mWeight, new Date());
			if (role > 0) {
				map.put("success", true);
				map.put("message", "修改成功");
			} else {
				map.put("success", false);
				map.put("message", "修改失败");
			}

		}
		return map;
		
	}
	
	
	/***
	 * 通过id删除模块
	 * http://localhost:8006/module/deleteModule?mid=11
	 * @param mid
	 * @return
	 */
	@RequestMapping(value="/deleteModule",method=RequestMethod.DELETE)
	public Object deleteModule(Integer mid,String access_token) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if (moduleService.deleteMoudle(mid) > 0) {
				map.put("success", true);
				map.put("message", "删除成功");
			} else {
				map.put("success", false);
				map.put("message", "删除失败");
			}
		} catch (Exception e) {
			map.put("success", false);
			map.put("message", "该模块已有角色,删除失败");
		}

		return map;
	}
	
	
	
	
}
