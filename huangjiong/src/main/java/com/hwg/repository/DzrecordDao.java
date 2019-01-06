package com.hwg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hwg.entity.Dzrecord;

/**
 * @Description 点赞记录Dao
 * @author HJiong
 * @time 2019年1月5日 下午10:06:18
 */
public interface DzrecordDao extends JpaRepository<Dzrecord, Integer> {
	/**
	 * 更具评价id 用户id查询点赞记录
	 * @param uid
	 * @param cid
	 * @return
	 */
	public Dzrecord findDzrecordByUserIdAndCommentId(Integer uid,Integer cid);
	
	@Query(value="insert into dzrecordtb (comment_id,user_id) values(?1,?2)",nativeQuery=true)
	@Modifying
	public int add(Integer cid,Integer uid);
}
