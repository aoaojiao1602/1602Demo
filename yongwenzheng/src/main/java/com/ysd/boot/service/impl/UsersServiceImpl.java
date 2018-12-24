package com.ysd.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysd.boot.dao.UsersMapper;
import com.ysd.boot.entity.Users;
import com.ysd.boot.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersMapper usersMapper;
	
	//通过用户名查找用户
    public Users queryUserByUserName(String username) {
    	
    	return usersMapper.queryUserByUserName(username);
    }
   
    //通过用户id查找用户角色id
	public List<Integer> queryRoleIdByUserId(Integer uid){
		
		return usersMapper.queryRoleIdByUserId(uid);
	}
	
	
	
}
