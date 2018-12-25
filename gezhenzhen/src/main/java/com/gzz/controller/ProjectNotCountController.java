package com.gzz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.repository.ProjectNotCountReopsitory;
import com.gzz.service.ProjectNotCountService;

@RestController
@RequestMapping("/projectNotCount")
@CrossOrigin
public class ProjectNotCountController {
	@Autowired
	private ProjectNotCountService service;
	/**
	 * http://localhost:8021/projectNotCount/putProjectNotCount?projectNotCountUid=1&projectNotCountProjectId=4
	 * 
	 * @param projectNotCountUid用户id
	 * @param projectNotCountProjectId主题表的id
	 * @return
	 */
	@RequestMapping("/putProjectNotCount")
	public Object putProjectNotCount(Integer projectNotCountUid, Integer projectNotCountProjectId) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 查询当前用户有没有对主题进行过点赞
		int k = service.getUidNotCount(projectNotCountProjectId, projectNotCountUid);
		if (k > 0) {
			map.put("success", false);
			map.put("msg", "该用户对主题进行过点赞则不能进行点踩了");
		} else {
			// 查询当前用户是否对该主题进行点踩
			int n = service.getProjectNotCountByUid(projectNotCountUid, projectNotCountProjectId);
			if (n > 0) {
				// 如果当前用户点过踩则再次操作是取消点踩
				service.deleteProjectNotCountByUid(projectNotCountUid, projectNotCountProjectId);
				map.put("success", false);
				map.put("msg", "该用户已点过踩,再次点击是取消点踩");
			} else {
				// 如果当前用户没有点过踩则进行点踩
				service.putProjectNotCount(projectNotCountUid, projectNotCountProjectId);
				map.put("success", true);
				map.put("msg", "点踩成功");
			}
		}

		return map;
	}

}
