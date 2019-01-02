package com.lhf.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.lhf.entity.Hours;


public interface HoursRepository extends JpaRepository<Hours, Integer>,JpaSpecificationExecutor<Hours> {

	
	//添加课时
		@Query(value = "INSERT INTO hours(hour_course,hour_name,hour_parent_id,hour_sort)VALUES"
		+"(:#{#h.hourCourse},:#{#h.hourName},:#{#h.hourParentId},:#{#h.hourSort})",nativeQuery=true)
		@Modifying
		public int putHours(@Param("h") Hours h);
		
	//删除课时
		@Query(value = "DELETE FROM hours WHERE hour_id =?1",nativeQuery=true)
		@Modifying
		@Transactional
		public int deleteHoursById(Integer hourId);
		
	//修改课时
		@Query(value="UPDATE hours SET hour_course = :#{#h.hourCourse},hour_name = :#{#h.hourName} , hour_parent_id = :#{#h.hourParentId} WHERE hour_id = :#{#h.hourId}",nativeQuery=true)
		@Modifying
		@Transactional
		public int postHoursById(@Param("h") Hours h);

		//根据老师Id、课程Id查询章节
		@Query(value="SELECT * FROM hours h  WHERE  h.hour_course=?1 AND h.hour_parent_id=0 ORDER BY hour_sort ASC", nativeQuery = true)
		public List<Hours> getHoursBycourseCreatorAndcourseId(Integer courseId);
		
		/**
		 * 根据章节ID即父ID查询课时
		 * @param hourParentId
		 * @return
		 */
		@Query(value="SELECT * FROM hours h  WHERE h.hour_parent_id=?1 ORDER BY hour_sort ASC", nativeQuery = true)
		public List<Hours> queryHoursByhourParentId(Integer hourParentId);

}
