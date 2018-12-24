package com.ysd.boot.service;

import java.util.List;

import com.ysd.boot.entity.Users;

public interface UsersService {
   
	//通过用户名查找用户
    public Users queryUserByUserName(String username);
   
    //通过用户id查找用户角色id
	public List<Integer> queryRoleIdByUserId(Integer uid);
}
