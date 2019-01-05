package com.xiaozuanfeng.springcloud.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaozuanfeng.springcloud.dao.FansRepository;
import com.xiaozuanfeng.springcloud.entity.Fans;
import com.xiaozuanfeng.springcloud.entity.UserInfo;
import com.xiaozuanfeng.springcloud.services.FansServices;

@Service
public class FansServicesImpl implements FansServices {
	@Autowired
	private FansRepository fdao;

	@Override
	public List<Integer> getMyFans(Integer uid) {

		return fdao.getMyFans(uid);
	}

	@Override
	public List<Integer> getMyfocus(Integer uid) {
		return fdao.getMyfocus(uid);
	}
	@Override
	public Integer getIsMyfocus(Integer uid, Integer fid) {
		return fdao.getIsMyfocus(uid, fid);
	}
	
	@Override
	public Integer getMyFansCount(Integer uid) {
		return fdao.getMyFansCount(uid);
	}

	@Override
	public Integer getMyfocusCount(Integer uid) {
		return fdao.getMyfocusCount(uid);
	}

	@Override
	public int postMyfocus(Fans fans) {
		return fdao.postMyfocus(fans);
	}

	@Override
	public int deleteMyfocus(Integer uid, Integer fid) {
		return fdao.deleteMyfocus(uid, fid);
	}
}
