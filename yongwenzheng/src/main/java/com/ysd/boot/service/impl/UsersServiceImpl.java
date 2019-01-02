package com.ysd.boot.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ysd.boot.dao.UsersMapper;
import com.ysd.boot.entity.UserQ;
import com.ysd.boot.entity.Users;
import com.ysd.boot.service.UsersService;


@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersMapper usersMapper;
	
	
	/**
	 * 通过用户id得到角色id
	 * @param uid
	 * @return
	 */
	public int getRoleByUid(Integer uid) {
		
		return usersMapper.getRoleByUid(uid);
	}
	
	//通过用户名查找用户
    public Users queryUserByUserName(String username) {
    	
    	return usersMapper.queryUserByUserName(username);
    }
   
    //通过用户id查找用户角色id
	public List<Integer> queryRoleIdByUserId(Integer uid){
		
		return usersMapper.queryRoleIdByUserId(uid);
	}
	
	/**
	 * 查询条件
	 */
	private Specification<Users> getWhereClause(final UserQ usersWhere){
		return new Specification<Users>() {
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				Predicate predicate=criteriaBuilder.conjunction();
				List<Expression<Boolean>> list=predicate.getExpressions();
				if (usersWhere.getUsersName()!=null && !"".equals(usersWhere.getUsersName())) {
					list.add(criteriaBuilder.like(root.<String>get("userName"), "%"+usersWhere.getUsersName()+"%"));
				}
				if (usersWhere.getStartUsersCreateTime()!=null) {
					list.add(criteriaBuilder.greaterThanOrEqualTo(root.<Date>get("StartUsersCreateTime"), usersWhere.getStartUsersCreateTime()));
				}
				
				
				return predicate;
			}
			
		};
	}
	
	
	/**
	 * 多条件分页查询
	 */
	public Page<Users> findAll(UserQ userq, Integer page,Integer size) {
		Sort sort=new Sort(Sort.Direction.DESC,"usersCreateTime","usersLastLoginTime");
		Pageable pageable=new PageRequest(page, size,sort);
		System.out.println("userpageable==>"+pageable);
		return usersMapper.findAll(this.getWhereClause(userq), pageable);
	}

	/**
	 * 添加一个对象
	 */
	@Override
	@Transactional
	public int insertUsers(String usersName, String usersPassWord) {
		return usersMapper.insertUsers(usersName, usersPassWord);
	}
	/**
	 * 添加时根据用户名判断该用户的用户名是否相同
	 */
	@Override
	public Users queryUsers(String usersName) {
		return usersMapper.queryUsers(usersName);
	}

	/**
	 * 删除
	 */
	@Override
	@Transactional
	public int deleteUsers(Integer usersId) {
		return usersMapper.deleteUsers(usersId);
	}

	/**
	 * 修改密码
	 */
	@Override
	@Transactional
	public int updateUsers(String usersPassWord,Integer usersId) {
		
		return usersMapper.updateUsers(usersPassWord, usersId,new Date());
	}
	/**
	 * 重置密码
	 */
	@Override
	@Transactional
	public int updateUsersPassWord(Integer usersId,String userpwd) {
		
		return usersMapper.updateUsersPassWord(userpwd, usersId);
	}

	/**
	 * 锁定用户
	 */
	@Override
	@Transactional
	public int updateUsersIsLockout(Integer usersId) {
		Integer usersIsLockout=1;
		return usersMapper.updateUsersIsLockout(usersIsLockout, usersId);
	}

	/**
	 * 解锁用户
	 */
	@Override
	@Transactional
	public int updateUsersLockout(Integer usersId) {
		Integer usersIsLockout=0;
		return usersMapper.updateUsersLockout(usersIsLockout, usersId);
	}
	
	
	/***
	 * 通过用户id查询用户信息
	 * @param usersId
	 * @return
	 */
	public Users getUsersById(Integer usersId) {
		
		return usersMapper.getOne(usersId);
	}
	
	
	
	/****
                * 查询用户没有的角色
        * @param id
        * @return
      */		
   public List<Map<String, Object>> selectUsersNotRoles(Integer id){
	   
	   return usersMapper.selectUsersNotRoles(id);
   }
	 
   
   
     /****
              * 查询用户拥有的角色
       * @param id
       * @return
     */
   public List<Map<String, Object>> selectUsersRoles(Integer id){
	   
	   return usersMapper.selectUsersRoles(id);
   }
   
   
   
   
   /****
             *给用户添加角色
      * @param id
      * @return
      */
   @Transactional
   public int insertUsersRoles(Integer uid,Integer rid) {
	   
	   return usersMapper.insertUsersRoles(uid, rid);
   }




     /****
      	*给用户移除角色
      	* @param id
      	* @return
      	*/
    @Transactional
    public int deleteUsersRoles(Integer uid) {
    	
    	return usersMapper.deleteUsersRoles(uid);
    }



    	/***
    	 * 查询用户拥有角色的个数
    	 *判断用户，如果拥有两个角色
    	 *提示用户只能拥有一个角色
    	 * @param uid
    	 * @return
    	 */
    public int getUserRoleCount(Integer uid) {
    	
    	return usersMapper.getUserRoleCount(uid);
    }
	
}
