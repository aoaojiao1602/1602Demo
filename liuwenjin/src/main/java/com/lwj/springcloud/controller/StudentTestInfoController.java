package com.lwj.springcloud.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwj.springcloud.entity.Question;
import com.lwj.springcloud.service.StudentTestInfoService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
@RestController
public class StudentTestInfoController {
	@Autowired
	private StudentTestInfoService stService;
	
	/**
	 * 显示试卷详情
	 * @param stuid
	 * @param testId
	 * @return
	 */
	@ApiOperation(value="获取本次试卷信息", notes="获取试卷信息")
	@ApiImplicitParam(name = "stuid", value = "学生id", required = true,paramType="Integer")
	@RequestMapping(value="/studentTestInfo", method = RequestMethod.GET)
	public Object indexStudentTestInfo(int stuid,int testId) {
		Map<String, Object>  map=stService.indexStudentTestInfo(stuid, testId);
		List<Question> question=(List<Question>) map.get("question");
		map.put("question", question);
		return map;
	}
	/**
	 * 提交测试
	 * @param stuid
	 * @param testid
	 * @param daans
	 * @param qids
	 * @return
	 */
	@ApiOperation(value="提交本次考试", notes="生成分数")
	@ApiImplicitParam(name = "stuid", value = "学生id", required = true,paramType="Integer")
	@RequestMapping(value="/studentTestInfo", method = RequestMethod.PUT)
	public Object updatestudentTestInfoAndScore(int stuid,int testid,@RequestParam(value = "daans[]") String[] daans,@RequestParam(value = "qids[]") int[] qids) {
		//计算出分数
		int score=stService.checkDaan(qids,daans);
		stService.updateStudentTestInfoScore(stuid,testid,score);
		//Map<String, Object>  map=stuExaService.indexStudentExamInfo(stuid,examid);
		return score;
	}
}
