package com.gzz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.service.ProjectReportService;

@RestController
@RequestMapping("/projectReport")
@CrossOrigin
public class ProjectReportController {
	@Autowired
	private ProjectReportService service;
	/**
	 * http://localhost:8021/projectReport/putProjectReport?reportContent=22222&reportUid=1&projectId=1
	 * @param reportContent
	 * @param reportUid
	 * @param projectId
	 * @return
	 */
	@RequestMapping("/putProjectReport")
	public Object putProjectReport(String reportContent,Integer reportUid,Integer projectId) {
		Map<String, Object> map=new HashMap<String, Object>();
		int n=service.putProjectReport(reportContent, reportUid, projectId);
		if (n>0) {
			map.put("success", true);
			map.put("msg", "举报成功");
		} else {
			map.put("success", false);
			map.put("msg", "举报失败");
		}
		return map;
	}

}
