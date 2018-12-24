package com.ysd.boot.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ysd.boot.fallback.PermissionsServiceImpl;





@FeignClient(value="yongwenzheng",fallback=PermissionsServiceImpl.class)
public interface PermissionsService {
	/***
	 * 通过角色id得到权限id
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/che/queryPermissionIdByRoleId")
	public Object queryPermissionIdByRoleId(@RequestParam("rid")String rid);
	
	
	/**
	 *通过权限id得到权限
	 * @param permissionId
	 * @return
	 */
	@RequestMapping("/che/queryPermissionByPermissionId")
	public Object queryPermissionByPermissionId(@RequestParam("permissionId")String permissionId);
	
	
	
}
