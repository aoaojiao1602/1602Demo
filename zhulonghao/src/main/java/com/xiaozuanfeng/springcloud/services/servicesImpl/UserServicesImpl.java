package com.xiaozuanfeng.springcloud.services.servicesImpl;

import java.util.List;

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

		return udao.getUser(uid);
	}

	public List<UserInfo> getMyFans(List<Integer> ilist) {
		return udao.getMyFans(ilist);
	}
	public List<UserInfo> getMyfocus(List<Integer> ilist){
		return udao.getMyfocus(ilist);
	}
}
