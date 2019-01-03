package com.gzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.gzz.entity.PostbarNotGood;

public interface PostbarNotGoodRepository extends JpaRepository<PostbarNotGood, Integer> {
	
	/*
	 * 贴吧踩贴
	 */
	@Modifying
	@Transactional
	@Query(value = "insert into postbar_not_goodtb(postbar_not_good_postbar_id,u_id) values(?1,?2)", nativeQuery = true)
	public int putPostbarNotGood (Integer postbarNotGoodPostbarId,Integer uId);
	
	/*
	 * 贴吧取消踩贴
	 */
	@Modifying
	@Transactional
	@Query(value = "delete from postbar_not_goodtb where postbar_not_good_postbar_id=?1 and u_id=?2", nativeQuery = true)
	public int deletePostbarNotGood (Integer postbarNotGoodPostbarId,Integer uId);
	
	/*
	 * 查询用户是否对贴吧已经踩帖
	 */
	@Query(value = "select * from postbar_not_goodtb where postbar_not_good_postbar_id=?1 and u_id=?2", nativeQuery = true)
	public PostbarNotGood getPostbarNotGood (Integer postbarNotGoodPostbarId,Integer uId);
	
	/*
	 * 查询踩帖数
	 */
	@Query(value = "select count(*) from postbar_not_goodtb where postbar_not_good_postbar_id=?1", nativeQuery = true)
	public int getPostbarNotGoodCount (Integer postbarNotGoodPostbarId);
	
}
