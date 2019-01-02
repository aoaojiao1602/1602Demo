package com.xiaozuanfeng.springcloud.services;

import java.util.List;

import com.xiaozuanfeng.springcloud.entity.UserInfo;

public interface UserServices {
	/**
	 * 根据id获取用户信息返回UserInfo对象
	 * @param uid
	 * @return
	 */
	public UserInfo getUser(Integer uid);
	public List<UserInfo> getMyFans(List<Integer> ilist);
	public List<UserInfo> getMyfocus(List<Integer> ilist);
	public int updateById(UserInfo uid);
}
