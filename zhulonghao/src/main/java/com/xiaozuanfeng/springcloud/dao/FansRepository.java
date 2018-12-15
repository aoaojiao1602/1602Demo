package com.xiaozuanfeng.springcloud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.xiaozuanfeng.springcloud.entity.Fans;

public interface FansRepository extends JpaRepository<Fans, Integer> {
	/*
	 * 根据id获取我的粉丝
	 */
	@Query("from Fans f where f.f_fid =:uid")
	List<Fans> getMyFans(@Param("uid") Integer uid);

	/**
	 * 根据id获取我的关注
	 * 
	 * @param uid
	 * @return
	 */
	@Query("from Fans f where f.f_uid =:fid")
	List<Fans> getMyfocus(@Param("fid") Integer uid);

	/**
	 * 根据id获取我的粉丝数量
	 * 
	 * @param uid
	 * @return
	 */
	@Query(value = "SELECT COUNT(*) FROM fanstb WHERE f_ufid=?1", nativeQuery = true)
	@Modifying
	public int getMyFansCount(Integer uid);

	/**
	 * 根据id获取我的关注数量
	 * 
	 * @param uid
	 * @return
	 */
	@Query(value = "SELECT COUNT(*) FROM fanstb WHERE f_uid=?1", nativeQuery = true)
	@Modifying
	public int getMyfocusCount(Integer uid);

	/**
	 * 查询是否已经关注
	 * 
	 * @param uid
	 * @param fid
	 * @return
	 */
	@Query(value = "SELECT COUNT(*) FROM fanstb WHERE f_ufid=?1 AND f_uid=?2", nativeQuery = true)
	@Modifying
	public int getIsMyfocus(Integer uid, Integer fid);

	/**
	 * 根据用户id和关注id添加关注
	 * 
	 * @param uid
	 * @param fid
	 * @return
	 */
	@Query(value = "INSERT INTO fanstb ( f_ufid,f_uid)VALUES(?1,?2)", nativeQuery = true)
	@Modifying
	@Transactional
	public int postMyfocus(Integer uid, Integer fid);

	/**
	 * 根据用户id和关注id取消关注
	 * 
	 * @param uid
	 * @param fid
	 * @return
	 */
	@Query(value = "DELETE FROM fanstb WHERE f_fid =?2 and f_uid=?1", nativeQuery = true)
	@Modifying
	@Transactional
	public int deleteMyfocus(Integer uid, Integer fid);
}
