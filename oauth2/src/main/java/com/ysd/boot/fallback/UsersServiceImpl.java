package com.ysd.boot.fallback;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.ysd.boot.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{

	@Override
	public Object queryUserByUserName(String username) {
		// TODO Auto-generated method stub
		return Arrays.asList("queryUserByUserName服务调用失败","我是oauth服务降级");
	}

	@Override
	public Object queryRoleIdByUserId(Integer uid) {
		// TODO Auto-generated method stub
		return Arrays.asList("queryRoleIdByUserId服务调用失败","我是oauth服务降级");
	}

}
