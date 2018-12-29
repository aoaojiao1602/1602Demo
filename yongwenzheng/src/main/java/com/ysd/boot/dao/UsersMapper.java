package com.ysd.boot.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ysd.boot.entity.Users;

public interface UsersMapper extends JpaRepository<Users, Integer>,JpaSpecificationExecutor<Users>{
	
	/**
	 * 通过用户id得到角色id
	 * @param uid
	 * @return
	 */
	@Query(value = "SELECT  roles_users_id FROM users_roles WHERE users_roles_id=?1" , nativeQuery = true)
	public int getRoleByUid(Integer uid);
	
	
	//通过用户名查找用户
	@Query(value = "SELECT * FROM userstb WHERE users_name=?1" , nativeQuery = true)
	public Users queryUserByUserName(String username);
	
	//通过用户id查找用户角色id
    @Query(value = "SELECT roles_users_id FROM users_roles WHERE users_roles_id=?1" , nativeQuery = true)
    public List<Integer> queryRoleIdByUserId(Integer uid);
    
 // 添加一个用户对象
 		@Query(value = "INSERT INTO userstb(users_name,users_password,users_create_time,users_lock_out_time)VALUES(?1,?2,?3,?4,?5,?6)", nativeQuery = true)
 		@Modifying
 		public int insertUsers(String usersName, String usersPassword, 
 				Date usersCreateTime, Date usersLastLoginTime);

 		// 添加時根据用户名判断用户登录名是否相同
 		@Query(value = "SELECT * FROM userstb WHERE users_name=?1", nativeQuery = true)
 		public Users queryUsers(String usersName);

 		// 删除
 		@Query(value = "DELETE FROM userstb WHERE users_id=:usersId", nativeQuery = true)
 		@Modifying
 		public int deleteUsers(@Param(value = "usersId") Integer id);

 		// 修改
 		@Query(value = "UPDATE userstb SET users_password=?1 WHERE users_id=?2", nativeQuery = true)
 		@Modifying
 		public int updateUsers(String usersPassword, Integer usersId);

 		// 重置密码
 		@Query(value = "UPDATE userstb SET users_password=?1 WHERE users_id=?2", nativeQuery = true)
 		@Modifying
 		public int updateUsersPassWord(String password, Integer usersId);

 		// 锁定用户
 		@Query(value = "UPDATE userstb SET users_is_lockout=?1 WHERE users_id=?2", nativeQuery = true)
 		@Modifying
 		public int updateUsersIsLockout(String usersIsLockout, Integer usersId);

 		// 解锁用户
 		@Query(value = "UPDATE userstb SET users_is_lockout=?1 WHERE users_id=?2", nativeQuery = true)
 		@Modifying
 		public int updateUsersLockout(String usersIsLockout, Integer usersId);
    
    
}
