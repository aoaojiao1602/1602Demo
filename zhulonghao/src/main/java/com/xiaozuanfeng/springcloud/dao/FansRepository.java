package com.xiaozuanfeng.springcloud.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xiaozuanfeng.springcloud.entity.Fans;
import com.xiaozuanfeng.springcloud.entity.UserInfo;

public interface FansRepository extends JpaRepository<Fans, Integer> {
	/*
	 * 根据id获取我的粉丝
	 */
	@Query(value = "SELECT f_uid FROM fanstb WHERE f_ufid =?1", nativeQuery = true)
	List<Integer> getMyFans(Integer uid);

	/**
	 * 根据id获取我的关注
	 * 
	 * @param uid
	 * @return
	 */
	@Query(value = "SELECT f_ufid FROM fanstb WHERE f_uid =?1", nativeQuery = true)
	List<Integer> getMyfocus(Integer uid);

	/**
	 * 根据id获取我的粉丝数量
	 * 
	 * @param uid
	 * @return
	 */
	@Query(value = "SELECT COUNT(*) FROM fanstb WHERE f_ufid=?1", nativeQuery = true)
	Integer getMyFansCount(Integer uid);

	/**
	 * 根据id获取我的关注数量
	 * 
	 * @param uid
	 * @return
	 */
	@Query(value = "SELECT COUNT(*) FROM fanstb WHERE f_uid=?1", nativeQuery = true)
	Integer getMyfocusCount(Integer uid);

	/**
	 * 查询是否已经关注
	 * 
	 * @param uid
	 * @param fid
	 * @return
	 */
	@Query(value = "SELECT COUNT(*) FROM fanstb WHERE f_ufid=?1 AND f_uid=?2", nativeQuery = true)
	Integer getIsMyfocus(Integer uid, Integer fid);

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
	@Query(value = "DELETE FROM fanstb WHERE f_ufid =?1 and f_uid=?2", nativeQuery = true)
	@Modifying
	@Transactional
	public int deleteMyfocus(Integer fid, Integer uid);
}
