package com.xiaozuanfeng.springcloud.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.xiaozuanfeng.springcloud.entity.Fans;
import com.xiaozuanfeng.springcloud.entity.UserInfo;

public interface FansServices {
	public List<Integer> getMyFans(@Param("uid") Integer uid);

	public List<Integer> getMyfocus(@Param("fid") Integer uid);

	Integer getMyFansCount(Integer uid);

	Integer getMyfocusCount(Integer uid);

	Integer getIsMyfocus(Integer uid, Integer fid);
	
	public int postMyfocus(Fans fans);

	public int deleteMyfocus(Integer uid, Integer fid);
}
