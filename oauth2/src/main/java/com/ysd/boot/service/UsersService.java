package com.ysd.boot.service;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ysd.boot.entity.Users;
import com.ysd.boot.fallback.UsersServiceImpl;

@FeignClient(value="yongwenzheng",fallback=UsersServiceImpl.class)
public interface UsersService {

	/***
	 * 通过用户名查找用户
	 * @param username
	 * @return
	 */
	@RequestMapping("/che/queryUserByUserName")
	public Object queryUserByUserName(@RequestParam("username")String username);
	
	/***
	 * 通过用户id查找用户角色id
	 * @param uid
	 * @return
	 */
	@RequestMapping("/che/queryRoleIdByUserId")
	public Object queryRoleIdByUserId(@RequestParam("uid")Integer uid);
	
}
