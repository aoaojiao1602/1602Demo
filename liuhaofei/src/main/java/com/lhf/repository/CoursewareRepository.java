package com.lhf.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import com.lhf.entity.Courseware;

public interface CoursewareRepository extends JpaRepository<Courseware, Integer>,JpaSpecificationExecutor<Courseware>{
	//给章节添加课时
	@Query(value = "INSERT INTO courseware(cw_url,cw_category,cw_hour,cw_name)VALUES"
	+"(:#{#cw.cwUrl},:#{#cw.cwCategory},:#{#cw.cwHour},:#{#cw.cwName})", nativeQuery = true)
	@Modifying
	@Transactional
	public int putCourseware(@Param("cw") Courseware cw);
	
	
	// 删除课程
		@Query(value = "DELETE FROM Courseware WHERE cwId =?1")
		@Modifying
		@Transactional
		public int deleteCoursewareById(Integer cwId);


	//修改章节
		@Query(value="UPDATE Courseware SET cw_url = :#{#cw.cwUrl},cw_category = :#{#cw.cwCategory} , cw_hour = :#{#cw.cwHour} , cw_name = :#{#cw.cwName} WHERE cw_id = :#{#cw.cwId}")
		@Modifying
		@Transactional
		public int postCoursewareById(@Param("cw") Courseware cw);

		//查询章节

		


}
