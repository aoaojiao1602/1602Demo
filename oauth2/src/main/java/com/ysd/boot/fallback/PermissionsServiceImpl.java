package com.ysd.boot.fallback;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ysd.boot.service.PermissionsService;
@Service
public class PermissionsServiceImpl implements PermissionsService{

	@Override
	public Object queryPermissionIdByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return Arrays.asList("queryPermissionIdByRoleId服务调用失败","我是oauth服务降级");
	}

	@Override
	public Object queryPermissionByPermissionId(String permissionId) {
		// TODO Auto-generated method stub
		return Arrays.asList("queryPermissionByPermissionId服务调用失败","我是oauth服务降级");
	}

}
