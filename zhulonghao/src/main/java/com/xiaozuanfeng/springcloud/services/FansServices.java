package com.xiaozuanfeng.springcloud.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.xiaozuanfeng.springcloud.entity.Fans;

public interface FansServices {
	public List<Fans> getMyFans(@Param("uid") String uid);

	public List<Fans> getMyfocus(@Param("fid") String uid);

	public int getMyFansCount(Integer uid);

	public int getMyfocusCount(Integer uid);
}