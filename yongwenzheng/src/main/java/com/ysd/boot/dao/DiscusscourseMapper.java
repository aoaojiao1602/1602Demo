package com.ysd.boot.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ysd.boot.entity.Discusscourse;


public interface DiscusscourseMapper extends JpaRepository<Discusscourse, Integer>,JpaSpecificationExecutor<Discusscourse>{

	/***
	 * 添加精彩讨论推荐
	 * @param course
	 * @return
	 */
	@Modifying
	@Query(value = "INSERT INTO discusscoursetb (kech_id, teacher_id) VALUES(?1,?2)", nativeQuery = true)
	public int addDiscusscourse(@Param("kechId")Integer kechId,@Param("teacherId")Integer teacherId);
	
	/**
	 * 通过id进行删除精彩讨论推荐
	 * @param courseId
	 * @return
	 */
	@Modifying
	@Query(value = "DELETE FROM discusscoursetb WHERE discusscourse_id = ?1 " , nativeQuery = true)
	public int deleteDiscusscourse(@Param("discusscourseId")Integer discusscourseId);
	
	/**
	 * 通过id进行修改精彩讨论推荐
	 * @param course
	 * @return
	 */
    @Modifying
	@Query(value = "UPDATE discusscoursetb SET discuss_status = :#{#discusscourse.discussStatus} , discuss_weigh = :#{#discusscourse.discussWeigh} , positions_id = :#{#discusscourse.positionsId} WHERE discusscourse_id = :#{#discusscourse.discusscourseId}", nativeQuery = true)
	public int updateDiscusscourse(@Param("discusscourse")Discusscourse discusscourse);
	
	/***
	  * 通过位置id进行分页查询
	 * @param position
	 * @param pageable
	 * @return
	 */    
	public Page<Discusscourse> findByPositionsId(Integer positionId,Pageable pageable);
	
	
	/**
	 * 通过位置id得到精彩讨论推荐
	 * @param positionId
	 * @return
	 */
	@Query(value = "SELECT * FROM discusscoursetb WHERE positions_id = ?1 " , nativeQuery = true)
	public List<Discusscourse> getDiscusscourseByPositionId(@Param("positionId")Integer positionId);
	
}
