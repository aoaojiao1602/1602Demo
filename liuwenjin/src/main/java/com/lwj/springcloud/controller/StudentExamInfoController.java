/**
 * 
 */ 
package com.lwj.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lwj.springcloud.entity.Entitysearch;
import com.lwj.springcloud.entity.Examinfo;
import com.lwj.springcloud.entity.Question;
import com.lwj.springcloud.entity.StudentExamInfo;
import com.lwj.springcloud.service.StudentExamInfoService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * 项目名称：liuwenjin
 * 类名称：StudentExamInfoController
 * 类描述：
 * 创建人：rain
 * 创建时间：2018年12月22日 下午5:13:27
 * 修改人：rain
 * 修改时间：2018年12月22日 下午5:13:27
 * 修改备注：
 * @version
 *
*/
@RestController
public class StudentExamInfoController {
	@Autowired
	private StudentExamInfoService stuExaService;
	@ApiOperation(value="获取本次试卷信息", notes="获取试卷信息")
	@ApiImplicitParam(name = "stuid", value = "学生id", required = true,paramType="Integer")
	@RequestMapping(value="/studentExamInfo", method = RequestMethod.GET)
	public Object indexStudentExamInfo(int stuid,int examid) {
		Map<String, Object>  map=stuExaService.indexStudentExamInfo(stuid,examid);
		List<Question> question=(List<Question>) map.get("question");
		for (int i = 0; i < question.size(); i++) {
				if (question.get(i).getOptions()!=null) {
					question.get(i).getOptions().setAnswer(null);
				}
				if (question.get(i).getJudges()!=null) {
					question.get(i).getJudges().setAnswer(null);
				}
				if (question.get(i).getFillblanks()!=null) {
					question.get(i).getFillblanks().setAnswer(null);
				}
		}
		map.put("question", question);
		return map;
	}
	@ApiOperation(value="修改考试题库表", notes="修改学生考试题库记录表")
	@ApiImplicitParam(name = "stuid", value = "学生id", required = true,paramType="Integer")
	@RequestMapping(value="/studentExamInfoQuestion", method = RequestMethod.PUT)
	public Object updateStudentExamInfoQuestion(String daan,int examid,int qid,int stuid) {
		return stuExaService.updateStudentExamInfoQuestion(daan,examid,qid,stuid);
	}
	@ApiOperation(value="修改学生剩余考试时间", notes="修改学生剩余考试时间")
	@ApiImplicitParam(name = "stuid", value = "学生id", required = true,paramType="Integer")
	@RequestMapping(value="/updateStudentExamInfo", method = RequestMethod.PUT)
	public Object updateStudentExamInfoTime(int stuid,int examid) {
		stuExaService.updateStudentExamInfoTime(stuid,examid);
		return 	stuExaService.queryStudentExamInfoTime(stuid,examid);
	}
	@ApiOperation(value="提交本次考试", notes="生成分数")
	@ApiImplicitParam(name = "stuid", value = "学生id", required = true,paramType="Integer")
	@RequestMapping(value="/studentExamInfo", method = RequestMethod.PUT)
	public Object updatestudentExamInfoAndScore(int stuid,int examid,@RequestParam(value = "daans[]") String[] daans,@RequestParam(value = "qids[]") int[] qids) {
		//分数
		int score=stuExaService.checkDaan(qids,daans);
		stuExaService.updateStudentExamInfoScore(stuid,examid,score);
		//Map<String, Object>  map=stuExaService.indexStudentExamInfo(stuid,examid);
		return score;
	}
}
