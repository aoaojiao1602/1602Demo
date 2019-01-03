package com.gzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.gzz.entity.PostbarGood;

public interface PostbarGoodRepository extends JpaRepository<PostbarGood, Integer> {
	
	/*
	 * 贴吧顶贴
	 */
	@Modifying
	@Transactional
	@Query(value = "insert into postbar_goodtb(postbar_good_postbar_id,u_id) values(?1,?2)", nativeQuery = true)
	public int putPostbarGood (Integer postbarGoodPostbarId,Integer uId);
	
	/*
	 * 贴吧取消顶贴
	 */
	@Modifying
	@Transactional
	@Query(value = "delete from postbar_goodtb where postbar_good_postbar_id=?1 and u_id=?2", nativeQuery = true)
	public int deletePostbarGood (Integer postbarGoodPostbarId,Integer uId);
	
	/*
	 * 查询用户是否对帖子已经点过赞
	 */
	@Query(value = "select * from postbar_goodtb where postbar_good_postbar_id=?1 and u_id=?2", nativeQuery = true)
	public PostbarGood getPostbarGood (Integer postbarGoodPostbarId,Integer uId);
	
	/*
	 * 查询点赞数
	 * by PostbarId
	 */
	@Query(value = "select count(*) from postbar_goodtb where postbar_good_postbar_id=?1", nativeQuery = true)
	public int getPostbarGoodCountByPostbarId (Integer postbarGoodPostbarId);
	
	/*
	 * 查询获赞数
	 * by uId
	 */
	@Query(value="SELECT COUNT(*) FROM postbar_goodtb WHERE postbar_good_postbar_id IN(SELECT postbar_id FROM postbartb WHERE u_id=?1)", nativeQuery=true)
	public int getPostbarGoodCountByuId(Integer uId);
	
}
