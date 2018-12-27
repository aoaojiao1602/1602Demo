package com.xiaozuanfeng.springcloud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xiaozuanfeng.springcloud.entity.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Integer> {
	/**
	 * 根据id获取用户
	 * 
	 * @param uid
	 * @return
	 */
	@Query(value = "SELECT * FROM userinfotb WHERE u_uid = ?1 ", nativeQuery = true)
	public UserInfo getUser(Integer uid);

	/**
	 * 根据id获取我的粉丝
	 * 
	 * @param uid
	 * @return
	 */
	@Query(value = "SELECT * FROM userinfotb WHERE u_uid IN(?1)", nativeQuery = true)
	public List<UserInfo> getMyFans(List<Integer> ilist);

	/**
	 * 根据id获取我的关注
	 * 
	 * @param uid
	 * @return
	 */
	@Query(value = "SELECT * FROM userinfotb WHERE u_uid IN(?1)", nativeQuery = true)
	List<UserInfo> getMyfocus(List<Integer> ilist);
}
