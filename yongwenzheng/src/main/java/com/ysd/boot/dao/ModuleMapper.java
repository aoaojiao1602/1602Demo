package com.ysd.boot.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ysd.boot.entity.Module;

public interface ModuleMapper extends JpaRepository<Module, Integer>,JpaSpecificationExecutor<Module>{
	
	
	/***
	 * 查 询模块子菜单
	 * @param name
	 * @return
	 */
	@Query(value = "SELECT * FROM moduletb WHERE parent_id=?1 AND module_name LIKE %?2%" , nativeQuery = true)
	public List<Module> queryChildrenById(Integer moduleParentId,String moduleName);
	
	
	/***
	 *查询角色拥有的模块id
	 */
	@Query(value = "SELECT module_roles_id FROM module_roles WHERE roles_module_id=?1" , nativeQuery = true)
	public List<Integer> queryByRolesIdGetSModuleId(Integer roleIds);
	
	
	/***
	 *通过角色id删除rolemodule的模块
	 */
	@Query(value = "DELETE FROM module_roles WHERE roles_module_id = ?1" , nativeQuery = true)
	@Modifying
	public int deleteRolesMoudelBy(Integer id);
	
	/***
	 *通过角色id添加模块
	 */
	@Query(value = "INSERT INTO module_roles (roles_module_id,module_roles_id) VALUES(?1,?2)" , nativeQuery = true)
	@Modifying
	public int insertRolesMoudelBy(Integer roleId,Integer moduleId);
	
	
	
	/***
	 * 添加模块
	 * @param mName
	 * @param mUrl
	 * @param mWeight
	 * @param pid
	 * @return
	 */
	@Query(value = "INSERT INTO moduletb ( module_name, module_url, module_weight, parent_id) VALUES(?1,?2,?3,?4)" , nativeQuery = true)
	@Modifying
	public int insertMoudle(String mName,String mUrl,Integer mWeight,Integer pid);
	
	
	/***
	 * 通过模块名称查询模块
	 * @param mName
	 * @return
	 */
	@Query(value = "SELECT module_name FROM moduletb WHERE module_name=?1" , nativeQuery = true)
	public String getMoudleByName(String mName);
	
	
	/***
	 * 修改模块
	 * @param mid
	 * @param mName
	 * @param mUrl
	 * @param mWeight
	 * @param pid
	 * @param upDate
	 * @return
	 */
	@Query(value = "UPDATE moduletb SET module_name =?2, module_url =?3, module_weight =?4,module_last_update_time =?5 WHERE module_id = ?1" , nativeQuery = true)
	@Modifying
	public int updateMoudle(Integer mid,String mName,String mUrl,Integer mWeight,Date upDate);
	
	
	/***
	 * 通过id删除模块
	 * @param mid
	 * @return
	 */
	@Query(value = "DELETE FROM moduletb WHERE module_id = ?1" , nativeQuery = true)
	@Modifying
	public int deleteMoudle(Integer mid);
	
	
}
