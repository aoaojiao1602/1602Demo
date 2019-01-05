package com.ysd.boot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ysd.boot.entity.UserQ;
import com.ysd.boot.entity.Users;
import com.ysd.boot.service.UsersService;
import com.ysd.boot.tool.PasswordEncoder;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping(value="/user",name="用户管理")
public class UsersController {
	
	@Autowired
	private UsersService usersService;

	/**
	 * 多条件分页查询
	 * http://localhost:8006/user/queryAllByPage?page=1&rows=10
	 * @param userQ
	 * @return
	 */
	@RequestMapping(value="/queryAllByPage",method=RequestMethod.GET)
	public Object queryAllByPage(UserQ userq, Integer page, Integer rows,String access_token ) {
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
	 * 添加一个对象 
	 * http://localhost:8006/user/insertUsers?usersName=admin&usersPassWord=123456
	 * @param userName
	 * @param userPassWord
	 * @param userEmail
	 * @param userTelephone
	 * @return
	 */
	@RequestMapping(value="/insertUsers",method=RequestMethod.PUT)
	public Object insertUsers(String usersName, String usersPassWord,String access_token) {
		Map<String, Object> map = new HashMap<String, Object>();
		Users users = usersService.queryUsers(usersName);
		
		PasswordEncoder encoderMd5 = new PasswordEncoder(usersName, "MD5");
		String encodePass = encoderMd5.encode(usersPassWord, 5);// 用户名做盐,哈希五次MD5加密
		
		
		if (users != null) {
			map.put("success", false);
			map.put("message", "用户名已存在，请更换用户名");
		} else {
			int user = usersService.insertUsers(usersName, encodePass);
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
	 * 通过id删除用户
	 * http://localhost:8006/user/deleteUsers?usersId=7
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/deleteUsers",method=RequestMethod.DELETE)
	public Object deleteUsers(Integer usersId,String access_token) {
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
			map.put("message", "该用户已有角色有关,删除失败");
		}
		return map;
	}

	

	/**
	 * 重置密码
	 * http://localhost:8006/user/updateUsersPassWord?usersId=7
	 * @param userId
	 * @return
	 */
	@RequestMapping("/updateUsersPassWord")
	public Object updateUsersPassWord(Integer usersId,String access_token) {
		Map<String, Object> map = new HashMap<String, Object>();
		Users users=usersService.getUsersById(usersId);
		
		PasswordEncoder encoderMd5 = new PasswordEncoder(users.getUsersName(), "MD5");
		String encodePass = encoderMd5.encode("123456", 5);// 用户名做盐,哈希五次MD5加密
		
		int updatePwd = usersService.updateUsersPassWord(usersId, encodePass);
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
	 * 锁定用户 
	 * http://localhost:8006/user/updateUsersIsLockout?userId=7
	 * @param userId
	 * @return
	 */
	@RequestMapping("/updateUsersIsLockout")
	public Object updateUsersIsLockout(Integer userId,String access_token) {
		Map<String, Object> map = new HashMap<String, Object>();
		Users users=usersService.getUsersById(userId);
		if (users.getUsersIsLockout()==1) {
			map.put("success", false);
			map.put("message", "用户已经锁定，请勿再次操作");
		}
		else {
			int updateIsLockout = usersService.updateUsersIsLockout(userId);
			if (updateIsLockout > 0) {
				map.put("success", true);
				map.put("message", "锁定用户成功");
			} else {
				map.put("success", false);
				map.put("message", "锁定用户失败");
			}
		}	
		return map;
	}

	/**
	 * 解锁用户 
	 * http://localhost:8006/user/updateUsersLockout?usersId=7
	 * @param userId
	 * @return
	 */
	@RequestMapping("/updateUsersLockout")
	public Object updateUsersLockout(Integer usersId,String access_token) {
		Map<String, Object> map = new HashMap<String, Object>();
		Users users=usersService.getUsersById(usersId);
		if (users.getUsersIsLockout()==0) {
			map.put("success", false);
			map.put("message", "用户已经解锁，请勿再次操作");
		}
		else {
			int updateIsLockout = usersService.updateUsersLockout(usersId);
			if (updateIsLockout > 0) {
				map.put("success", true);
				map.put("message", "解锁用户成功");
			} else {
				map.put("success", false);
				map.put("message", "解锁用户失败");
			}
		}
		
		return map;
	}
	
	
	
	/****
	 	* 查询用户没有的角色
	 	*  http://localhost:8006/user/selectUsersNotRoles?id=7
        * @param id
        * @return
        */
	@RequestMapping("/selectUsersNotRoles")
	public Object selectUsersNotRoles(Integer id,String access_token) {
		
		return usersService.selectUsersNotRoles(id);
	}



	/****
                 * 查询用户拥有的角色
        * http://localhost:8006/user/selectUsersRoles?id=7
        * @param id
        * @return
    */
   @RequestMapping("/selectUsersRoles")
   public Object selectUsersRoles(Integer id,String access_token) {
	   
	   return usersService.selectUsersRoles(id);
   }



   	/****
   	 	*给用户添加角色
   	 	*http://localhost:8006/user/insertUsersRoles?uid=7&rid=
   	 	* @param id
   	 	* @return
   	 	*/
   @RequestMapping("/insertUsersRoles")
   public Object insertUsersRoles(Integer uid,Integer rid,String access_token) {
		Map<String, Object> map = new HashMap<String, Object>();
		/***
  	 	* 查询用户拥有角色的个数
  	 	*判断用户，如果拥有两个角色
  	 	*提示用户只能拥有一个角色
  	 	* @param uid
  	 	* @return
  	 	*/
		if (usersService.getUserRoleCount(uid)>=1) {
			map.put("success", false);
			map.put("message", "用户只能拥有一个角色，请删除原有角色，再添加新角色");
		}
		else {
			
			if (usersService.insertUsersRoles(uid, rid)>0) {
				map.put("success", true);
				map.put("message", "添加角色成功");
			}else {
				map.put("success", false);
				map.put("message", "添加角色失败");
			}
		}
		
		return map;
   }




   	/****
   	 	*给用户移除角色
   	 	*http://localhost:8006/user/deleteUsersRoles?uid=7
   	 	* @param id
   	 	* @return
   	 	*/
   @RequestMapping("/deleteUsersRoles")
   public Object deleteUsersRoles(Integer uid,String access_token) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (usersService.deleteUsersRoles(uid)>0) {
			map.put("success", true);
			map.put("message", "删除角色成功");
		}else {
			map.put("success", false);
			map.put("message", "删除角色失败");
		}
	  return map;
  }



	
	

}
