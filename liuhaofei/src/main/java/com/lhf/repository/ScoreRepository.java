package com.lhf.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import com.lhf.entity.Score;

public interface ScoreRepository extends JpaRepository<Score, Integer>,JpaSpecificationExecutor<Score> {
	//添加
	@Query(value = "INSERT INTO score (score_content, score_course,courses_score) VALUES(:#{#s.scoreContent} ,:#{#s.scoreCourse},:#{#s.courses.courseId});", nativeQuery = true)
	@Modifying
	@Transactional
	public int putScore(@Param("s") Score s);
	//删除
	@Query(value = "DELETE FROM score WHERE score_id =?1 ;", nativeQuery = true)
	@Modifying
	@Transactional
	public int deleteScoreById(Integer scoreId);
	//修改
	@Query(value = "UPDATE score SET score_content = :#{#s.scoreContent} WHERE score_id = :#{#s.scoreId} ;", nativeQuery = true)
	@Modifying
	@Transactional
	public int postScoreById(@Param("s") Score s);
	//根据课程Id查询评分标准
	@Query(value="SELECT * FROM score WHERE score_course=?1 ", nativeQuery = true)
	public List<Score> getScoreBycourseId(Integer courseId);
}
