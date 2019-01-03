package com.lhf.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.lhf.entity.Pic;

public interface PicRepository extends JpaRepository<Pic, Integer> ,JpaSpecificationExecutor<Pic>{
	////添加图片
	@Query(value="INSERT INTO pic(pic_url,pic_course)VALUES(:#{#p.picCourse},:#{#p.picUrl})", nativeQuery = true)
	@Modifying
	@Transactional
	public int putPic(@Param("p") Pic p); 
	////删除图片
	@Query(value="DELETE FROM pic WHERE pic_id=?1", nativeQuery = true)
	@Modifying
	public int deletePicByid(Integer picId);
	//修改图片
	@Query(value="UPDATE pic SET pic_url=:#{#p.picUrl},pic_course=:#{#p.picCourse} WHERE pic_id=:#{#p.picId}", nativeQuery = true)
	@Modifying
	@Transactional
	public int postPic(@Param("p") Pic p); 
	//根据课程Id查询图片
	@Query(value="SELECT * FROM pic WHERE pic_course=?1 ", nativeQuery = true)
	public List<Pic> getPicBycourseId(Integer courseId);
}
