package com.ysd.boot.service;

import java.util.List;
import java.util.Map;

import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ysd.boot.entity.UserQ;
import com.ysd.boot.entity.Users;

public interface UsersService {
   
	/**
	 * 通过用户id得到角色id
	 * @param uid
	 * @return
	 */
	public int getRoleByUid(Integer uid);
	
	//通过用户名查找用户
    public Users queryUserByUserName(String username);
   
    //通过用户id查找用户角色id
	public List<Integer> queryRoleIdByUserId(Integer uid);
	
	// 多条件分页查询
		public Page<Users> findAll(UserQ userQ, Integer page, Integer size);

		// 添加一个对象
		public int insertUsers(String usersName, String usersPassword);

		// 添加時根据用户名判断用户登录名是否相同
		public Users queryUsers(String usersName);
		

		// 删除
		public int deleteUsers(Integer usersId);

		// 修改密码
		public int updateUsers(String usersPassword, Integer usersId);

		// 重置密码
		public int updateUsersPassWord(Integer usersId,String userpwd);

		// 锁定用户
		public int updateUsersIsLockout(Integer usersId);

		// 解锁用户
		public int updateUsersLockout(Integer usersId);
		
		
		
		/***
		 * 通过用户id查询用户信息
		 * @param usersId
		 * @return
		 */
		public Users getUsersById(Integer usersId);
		
		
		
		
		/****
                      * 查询用户没有的角色
           * @param id
           * @return
         */		
		public List<Map<String, Object>> selectUsersNotRoles(Integer id);
		
		
		
		 /****
                         * 查询用户拥有的角色
            * @param id
            * @return
        */
	    public List<Map<String, Object>> selectUsersRoles(Integer id);
	    
	    
	    
	    /****
                      *给用户添加角色
           * @param id
           * @return
          */

       public int insertUsersRoles(Integer uid,Integer rid);

 


     /****
                 *给用户移除角色
        * @param id
        * @return
       */
      public int deleteUsersRoles(Integer uid);

   
      
      /***
              * 查询用户拥有角色的个数
              *判断用户，如果拥有两个角色
              *提示用户只能拥有一个角色
       * @param uid
       * @return
       */
     public int getUserRoleCount(Integer uid);

	
}
