package com.ysd.boot.dao;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ysd.boot.entity.Roles;

public interface RolesMapper extends JpaRepository<Roles, Integer>{
	
	/***
	 * 通过角色id得到角色名称
	 * @param rid
	 * @return
	 */
	   @Query(value = "SELECT roles_name FROM roletb WHERE roles_id=?1", nativeQuery = true)
	   public String getRoleNameByRid(Integer rid);
	
	    // 角色添加
		@Query(value = "INSERT INTO roletb(roles_name,roles_explan,roles_create_time)VALUES(?1,?2,?3)", nativeQuery = true)
		@Modifying
		public int insertRoles(String rolesName, String rolesExplan, Date rolesCreateTime);

		
		// 添加时判断角色名称是否重复
		@Query(value = "SELECT roles_name FROM roletb WHERE roles_name=:rolesName", nativeQuery = true)
		public String findRolesName(@Param(value = "rolesName") String rolesName);
	
		
		// 单个删除
		@Query(value = "DELETE FROM roletb WHERE roles_id=?1", nativeQuery = true)
		@Modifying @Transactional
		public int deleteOneRoles(Integer rolesId);
			
		
		// 角色修改
		@Query(value = "UPDATE roletb SET roles_name=?1,roles_explan=?2,roles_last_update_time=?4 WHERE roles_id=?3", nativeQuery = true)
		@Modifying
		public int updateRoles(String rolesName, String rolesExplan, Integer rolesId,Date upDate);

		
		
		/***=
		 * 带条件的分页查询
		 * @param name
		 * @param pageable
		 * @return
		 */
		public Page<Roles> findByRolesNameContaining(String name,Pageable pageable);
}
