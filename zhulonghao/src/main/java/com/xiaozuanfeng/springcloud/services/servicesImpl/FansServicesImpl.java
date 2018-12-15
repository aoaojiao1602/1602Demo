package com.xiaozuanfeng.springcloud.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaozuanfeng.springcloud.dao.FansRepository;
import com.xiaozuanfeng.springcloud.entity.Fans;
import com.xiaozuanfeng.springcloud.services.FansServices;

@Service
public class FansServicesImpl implements FansServices {
	@Autowired
	private FansRepository fdao;

	@Override
	public List<Fans> getMyFans(Integer uid) {

		return fdao.getMyFans(uid);
	}

	@Override
	public List<Fans> getMyfocus(Integer uid) {
		return fdao.getMyfocus(uid);
	}
	@Override
	public int getIsMyfocus(Integer uid, Integer fid) {
		return fdao.getIsMyfocus(uid, fid);
	}
	
	@Override
	public int getMyFansCount(Integer uid) {
		return fdao.getMyFansCount(uid);
	}

	@Override
	public int getMyfocusCount(Integer uid) {
		return fdao.getMyfocusCount(uid);
	}

	@Override
	public int postMyfocus(Integer uid, Integer fid) {
		return fdao.postMyfocus(uid, fid);
	}

	@Override
	public int deleteMyfocus(Integer uid, Integer fid) {
		return fdao.deleteMyfocus(uid, fid);
	}
}
