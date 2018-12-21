package com.lhf.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhf.entity.Score;
import com.lhf.entity.ScoreSearch;
import com.lhf.service.ScoreService;

@RestController
@RequestMapping("/score")
public class ScoreController {
	@Autowired
	private ScoreService scoreService;
	Map<String, Object> map = new HashMap<>();
	/**
	 * 评分标准添加方法
	 * http://localhost:8050/score/putScore?scoreContent=你好，我好，大家好&scoreCourse=1
	 * @param s 评分实体类
	 * @return
	 */
	@RequestMapping("putScore")
    public Object putScore(Score s) {
    	int S=scoreService.putCourses(s);
		if(S>0) {
			map.put("success",true);
			map.put("message","添加成功");
		}else {
			map.put("success",false);
			map.put("message","添加失败");
		}
	  return S;
  }
	/**
	 * 评分标准删除方法
	 * http://localhost:8050/score/deleteScore?scoreId=4
	 * @param scoreId 评分标准Id
	 * @return
	 */
	@RequestMapping("/deleteScore")
	public Object deleteScoreById(Integer scoreId) {
		int S=scoreService.deleteScoreById(scoreId);
		if(S>0) {
			map.put("success",true);
			map.put("message","删除成功");
		}else {
			map.put("success",false);
			map.put("message","删除失败");
		}
		return S;
	}
	/**
	 * 评分标准修改方法
	 * http://localhost:8050/score/postScore?scoreContent=asdfbcvccccc&scoreId=1
	 * @param s 评分实体类
	 * @return
	 */
	@RequestMapping("/postScore")
	public Object postScoreById(Score s) {
		int S=scoreService.postScoreById(s);
		if(S>0) {
			map.put("success",true);
			map.put("message","修改成功");
		}else {
			map.put("success",false);
			map.put("message","修改失败");
		}
		return S;
	}
	@RequestMapping("/query")
	public Object getScore(ScoreSearch s,int page,int limit) {
		Page<Score> sqlPage = scoreService.queryByDynamicSQLPage(s, page-1, limit);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("count", sqlPage.getTotalElements());
		map.put("data", sqlPage.getContent());
		return map;
	}
}
