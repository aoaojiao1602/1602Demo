package com.xiaozuanfeng.springcloud.services;

import com.xiaozuanfeng.springcloud.entity.UserInfo;

public interface UserServices {
	/**
	 * 根据id获取用户信息返回UserInfo对象
	 * @param uid
	 * @return
	 */
	public UserInfo getUser(Integer uid);
}
