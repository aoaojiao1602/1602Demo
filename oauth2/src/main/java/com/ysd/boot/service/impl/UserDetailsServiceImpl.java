package com.ysd.boot.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ysd.boot.entity.Permissions;
import com.ysd.boot.entity.Users;
import com.ysd.boot.service.PermissionsService;
import com.ysd.boot.service.UsersService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Mr.Yangxiufeng on 2017/12/27.
 * Time:16:37
 * ProjectName:Mirco-Service-Skeleton
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
	 @Autowired
	 private UsersService userservice;
	 
	 @Autowired
	 private PermissionsService permissionService;

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
		 ObjectMapper mapper = new ObjectMapper();
		 
			Object object=userservice.queryUserByUserName(username);
			
			 Users userResult=mapper.convertValue(object, Users.class);
			
			System.out.println("userResult====>"+userResult);
			
			Set<GrantedAuthority> grantedAuthorities = new HashSet<>();		 
			
			 List<Integer> ridObject= (List<Integer>) userservice.queryRoleIdByUserId(userResult.getUsersId());
			String rid="";
			for (Integer integer : ridObject) {
				rid+=integer.toString()+",";
			}
			rid = rid.substring(0,rid.length() - 1);
			System.out.println("rid====>"+rid);
			 List<Integer> permissionidObject=(List<Integer>) permissionService.queryPermissionIdByRoleId(rid);
			 String permissionid="";
				for (Integer integer1 : permissionidObject) {
					permissionid+=integer1.toString()+",";
				}
				permissionid=permissionid.substring(0,permissionid.length()-1);
			 System.out.println("permissionid======>"+permissionid);
			 
			 List<Permissions> permissionList = mapper.convertValue(permissionService.queryPermissionByPermissionId(permissionid), new TypeReference<List<Permissions>>() { });
			 System.out.println("permissionList====>"+permissionList);
			 
			 for (Permissions permission : permissionList) {
				 GrantedAuthority authority = new SimpleGrantedAuthority(permission.getPermissionValue());
	             grantedAuthorities.add(authority);
			}
			 
			
			  User user=new User(userResult.getUsersName(), new BCryptPasswordEncoder().encode(userResult.getUsersPassword()), grantedAuthorities);
		
		return user;
    }
}
