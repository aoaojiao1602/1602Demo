package com.ysd.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.boot.entity.UserQ;
import com.ysd.boot.entity.Users;
import com.ysd.boot.service.UsersService;

@RestController
@RequestMapping(value="/users",name="用户管理")
public class UsersController {
	
	@Autowired
	private UsersService usersService;

	/**
	 * 多条件分页查询 http://localhost:8080/user/queryAllByPage?userName=l&userIsLockout=0
	 * 
	 * @param userQ
	 * @return
	 */
	@RequestMapping("/queryAllByPage")
	public Object queryAllByPage(UserQ userq, Integer page, Integer rows) {
		System.out.println("page====>" + page);
		System.out.println("rows====>" + rows);
		Page<Users> page2 = null;
		page2 = usersService.findAll(userq, (page - 1), rows);
		Long total = page2.getTotalElements();
		List<Users> rows2 = page2.getContent();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", rows2);
		return map;
	}

	/**
	 * 添加一个对象 http://localhost:8080/user/insertUser
	 * 
	 * @param userName
	 * @param userPassWord
	 * @param userEmail
	 * @param userTelephone
	 * @return
	 */
	@RequestMapping("/insertUsers")
	public Object insertUsers(String usersName, String usersPassWord) {
		Map<String, Object> map = new HashMap<String, Object>();
		Users users = usersService.queryUsers(usersName);
		if (users != null) {
			map.put("success", false);
			map.put("message", "用户登录名不能相同");
		} else {
			int user = usersService.insertUsers(usersName, usersPassWord);
			if (user > 0) {
				map.put("success", true);
				map.put("message", "添加成功");
			} else {
				map.put("success", false);
				map.put("message", "添加失败");
			}
		}
		return map;
	}

	/**
	 * 删除一个对象 http://localhost:8080/user/deleteUser
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteUsers")
	public Object deleteUsers(Integer usersId) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("usersId====>" + usersId);
		try {
			int user = usersService.deleteUsers(usersId);
			if (user > 0) {
				map.put("success", true);
				map.put("message", "删除成功");
			} else {
				map.put("success", false);
				map.put("message", "删除失败");
			}
		} catch (Exception e) {
			map.put("success", false);
			map.put("message", "该用户与角色有关,删除失败");
		}
		return map;
	}

	

	/**
	 * 重置密码 http://localhost:8080/user/updatePassWord
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("/updateUsersPassWord")
	public Object updateUsersPassWord(Integer usersId) {
		Map<String, Object> map = new HashMap<String, Object>();
		int updatePwd = usersService.updateUsersPassWord(usersId);
		if (updatePwd > 0) {
			map.put("success", true);
			map.put("message", "重置密码成功");
		} else {
			map.put("success", false);
			map.put("message", "重置密码失败");
		}
		return map;
	}

	/**
	 * 锁定用户 http://localhost:8080/user/updateUserIsLockout
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("/updateUsersIsLockout")
	public Object updateUsersIsLockout(Integer userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		int updateIsLockout = usersService.updateUsersIsLockout(userId);
		if (updateIsLockout > 0) {
			map.put("success", true);
			map.put("message", "锁定用户成功");
		} else {
			map.put("success", false);
			map.put("message", "锁定用户失败");
		}
		return map;
	}

	/**
	 * 解锁用户 http://localhost:8080/user/updateUserLockout
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping("/updateUsersLockout")
	public Object updateUsersLockout(Integer usersId) {
		Map<String, Object> map = new HashMap<String, Object>();
		int updateIsLockout = usersService.updateUsersLockout(usersId);
		if (updateIsLockout > 0) {
			map.put("success", true);
			map.put("message", "解锁用户成功");
		} else {
			map.put("success", false);
			map.put("message", "解锁用户失败");
		}
		return map;
	}
	
	
	
	

}
