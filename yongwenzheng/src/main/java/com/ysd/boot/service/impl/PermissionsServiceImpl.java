package com.ysd.boot.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.ysd.boot.dao.PermissionsMapper;
import com.ysd.boot.entity.Permissions;
import com.ysd.boot.service.PermissionsService;

@Service
public class PermissionsServiceImpl implements PermissionsService{

	@Autowired
	private PermissionsMapper permissionMapper;
	
	@Autowired
    private RequestMappingHandlerMapping handlerMapping;//SpringMVC所有控制器中的请求映射集合
	
	   //通过角色id得到权限id
		public List<Integer> queryPermissionIdByRoleId(List<Integer> roleId){
			
			return permissionMapper.queryPermissionIdByRoleId(roleId);
		}
		//通过权限id得到权限
		public List<Permissions> queryPermissionByPermissionId(List<Integer> permissionId){
			
			return permissionMapper.queryPermissionByPermissionId(permissionId);
		}
		
		//得到所有权限
		public List<Permissions> queryAllPermission(){
			
			return permissionMapper.findAll();
		}
		
		/***
		 * 更新所有权限
		 */
		@Override
		public int updatePermissionsCount() {
			Map<RequestMappingInfo, HandlerMethod> requestMap = handlerMapping.getHandlerMethods();//SpringMVC所有控制器中的请求映射集合
			System.out.println("SpringMVC所有控制器中的请求映射集合=>"+requestMap);
			Collection<HandlerMethod> handlerMethods = requestMap.values();//获取所有controller中所有带有@RequestMapper注解的方法
			if(handlerMethods == null || handlerMethods.size() < 1 ) return 0;//成功更新0条数据
			List<Permissions> pList = new ArrayList<Permissions>();//收集到的待新增的权限集合		
			for(HandlerMethod method : handlerMethods){//遍历所有带有@RequestMapper注解的方法			
				RequestMapping anno = method.getMethodAnnotation(RequestMapping.class);//从控制器映射方法上取出@RequestMapper注解对象
				//@RequestMapper注解有没有name备注是作为一个权限的标志
				if( !"".equals(anno.name()) ){//@RequestMapper注解写了name属性才做权限收集：所以@RequestMapper注解有没有name备注是作为一个权限的标志
					RequestMapping namespaceMapping = method.getBeanType().getAnnotation(RequestMapping.class);//带有@RequestMapper注解的方法所在控制器类上的RequestMapping注解对象
					String namespace =  namespaceMapping.value()[0];//得到RequestMapping注解的value值,即命名空间,即模块
					String permissionValue = (namespace+":"+anno.value()[0]).replace("/", "");//得到权限 ,例如：user:delete 用户模块的删除权限
					System.out.println("得到权限 ,例如：user:delete 用户模块的删除权限=>"+permissionValue +"权限说明:"+anno.name());
					Permissions permission = new Permissions();//待添加的权限对象
					permission.setPermissionModule(namespaceMapping.name());
					permission.setPermissionName(anno.name());
					permission.setPermissionValue(permissionValue);
					//permission = new Permissions(permissionValue,namespaceMapping.name(), anno.name());//把权限控制注解@Permission解析为权限控制对象SysPermission,方便插入数据库权限表
					pList.add(permission);//把数据库没有存储的,收集容器中也没有收集到的的权限加入收集容器中.
				}			
			}
			List<Permissions> k=permissionMapper.saveAll(pList);
			
			return k.size();
		}
		
		
		
		
		/***
		 * 得到权限树
		 */
		public List<Permissions> queryPermissionTree(Integer roleId){
			
			
			List<Integer> pid=permissionMapper.queryByRolesIdGetPermissionsId(roleId);
			
			List<Permissions> list=permissionMapper.queryPermissionsGroupBy();
			
			for (Permissions permissions : list) {
				
				permissions.setChildren(permissionMapper.queryPermissionsByPermissionsModule(permissions.getPermissionModule()));
				
				
			}
			
			return list;
		}
}
