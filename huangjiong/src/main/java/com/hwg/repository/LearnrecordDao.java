package com.hwg.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hwg.entity.Learnrecord;

/**
 * @Description 学习记录 Dao层
 * @author HJiong
 * @time 2018年12月14日 下午1:52:51
 */
public interface LearnrecordDao extends JpaRepository<Learnrecord, Integer>{
	
		/**
		 *   查询出学习记录 根据学生id and 课程编号及章节
		 * @param 
		 * @return
		 */
		@Query(value="select * from learnrecordtb where learn_course_id=:kcId and learn_stu_id=:xsId ",nativeQuery=true)
		public List<Learnrecord> findlearnrecord(@Param("kcId")String kcId,@Param("xsId")String xsId);
		
		/**
		 * 	修改
		 * @param id
		 * @return
		 */
		@Query("update Learnrecord l set l.learnCourseRecord=:zjId , l.learnCourseTime=:jlTime where l.lrId=:id")
		@Modifying
		public int updateBylrId(@Param("zjId")String zjId,@Param("jlTime")Integer jlTime,@Param("id")Integer id);
		
		//查询指定时间段的课程学习记录 返回课程id
		@Query(value="SELECT learn_course_id,COUNT(learn_course_id) AS'number' FROM learnrecordtb WHERE update_time BETWEEN ?1 AND ?2 GROUP BY learn_course_id",nativeQuery=true)
		public List<Map<String, Object>> getLearnrecordByUpdateTime(String ksTime,String jsTime);
		
		/**
		 * 查询当前学生学习记录（jpa关键字方法）
		 * @param stuId
		 * @return
		 */
		public List<Learnrecord> findLearnrecordByLearnStuId(String stuId);

}
