package com.xiaozuanfeng.springcloud.dao;

import java.util.List;

import javax.transaction.Transactional;

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
	/**
	 * 根据id修改个人资料
	 * @param uid
	 * 
	 * @param uid
	 * @return
	 */
	@Query(value = "UPDATE userinfotb SET ui_nickname=:#{#uid.ui_nickname},ui_phone=:#{#uid.ui_phone},ui_truename=:#{#uid.ui_truename},ui_sex=:#{#uid.ui_sex},ui_birthday=:#{#uid.ui_birthday},ui_identitycard=:#{#uid.ui_identitycard},identity=:#{#uid.identity},education=:#{#uid.education},industry=:#{#uid.industry},jianjie=:#{#uid.jianjie},yuanx=:#{#uid.yuanx}  WHERE u_uid=:#{#uid.u_uid} ",nativeQuery = true)
	@Modifying
	@Transactional
	public int updateById(@Param("uid") UserInfo uid);
	
	/**
	 * 根据uid获取用户信息
	 * 
	 * @param uid
	 * @return
	 */
	@Query(value = "SELECT * FROM userinfotb WHERE uid = ?1 ", nativeQuery = true)
	@Modifying
	@Transactional
	public List<UserInfo> getUserId(Integer uid);
}
