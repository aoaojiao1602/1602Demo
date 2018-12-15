package com.xiaozuanfeng.springcloud.services.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaozuanfeng.springcloud.dao.UserRepository;
import com.xiaozuanfeng.springcloud.entity.UserInfo;
import com.xiaozuanfeng.springcloud.services.UserServices;
@Service
public class UserServicesImpl implements UserServices {
@Autowired
private UserRepository udao;
	@Override
	public UserInfo getUser(Integer uid) {
		
		return udao.findOne(uid);
	}

}
