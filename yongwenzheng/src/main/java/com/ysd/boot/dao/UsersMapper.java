package com.ysd.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.ysd.boot.entity.Users;

public interface UsersMapper extends JpaRepository<Users, Integer>,JpaSpecificationExecutor<Users>{
	
	//通过用户名查找用户
	@Query(value = "SELECT * FROM userstb WHERE users_name=?1" , nativeQuery = true)
	public Users queryUserByUserName(String username);
	
	//通过用户id查找用户角色id
    @Query(value = "SELECT roles_users_id FROM users_roles WHERE users_roles_id=?1" , nativeQuery = true)
    public List<Integer> queryRoleIdByUserId(Integer uid);
}
