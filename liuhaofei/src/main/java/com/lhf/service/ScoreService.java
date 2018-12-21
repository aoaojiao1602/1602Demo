package com.lhf.service;





import org.springframework.data.domain.Page;

import com.lhf.entity.Score;
import com.lhf.entity.ScoreSearch;

public interface ScoreService {
	//添加
	public int putCourses(Score s);
	//删除
	public int deleteScoreById(Integer scoreId);
	//修改
	public int postScoreById(Score s);
	//查询
	public Page<Score> queryByDynamicSQLPage(ScoreSearch s,Integer page,Integer size);

}
