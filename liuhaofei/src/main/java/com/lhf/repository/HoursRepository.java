package com.lhf.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.lhf.entity.Hours;


public interface HoursRepository extends JpaRepository<Hours, Integer>,JpaSpecificationExecutor<Hours> {

	
	//添加课时
		@Query(value = "INSERT INTO hours(hour_course,hour_name,hour_parent_id)VALUES"
		+"(:#{#h.hourCourse},:#{#h.hourName},:#{#h.hourParentId})",nativeQuery=true)
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

		

}
