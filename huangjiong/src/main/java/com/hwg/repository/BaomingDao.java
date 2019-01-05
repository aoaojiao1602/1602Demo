package com.hwg.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hwg.entity.Baoming;

/**
 * @Description 报名记录Dao层
 * @author HJiong
 * @time 2019年1月3日 下午11:51:53
 */
public interface BaomingDao extends JpaRepository<Baoming, Integer> {
	
	/**
	 * 查询指定学生指定课程报名记录
	 * @param cid
	 * @param sid
	 * @return
	 */
	public Baoming findBaomingByCourseIdAndStuId(Integer cid,Integer sid);
	
	/**
	 * 查询报名记录
	 * @return
	 */
	@Query(nativeQuery=true,value="SELECT course_id,COUNT(course_id) AS'number' FROM baomingtb  GROUP BY course_id")
	public List<Map<String, Object>> findRm();
	
	/**
	 * 查询指定课程报名记录
	 * @return
	 */
	public List<Baoming> findBaomingByCourseId(Integer id);
	
	
	/**
	 *  查询指定学生的报名记录
	 * @param sid
	 * @return
	 */
	public  List<Baoming> findBaomingBystuIdOrderByCrateTimeDesc(Integer sid);
}
