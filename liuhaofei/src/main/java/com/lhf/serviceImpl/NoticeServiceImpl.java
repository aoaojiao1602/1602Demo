package com.lhf.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhf.entity.Notice;
import com.lhf.repository.NoticeRepository;
import com.lhf.service.NoticeService;
@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeRepository nRepository;
	@Override
	public int addNotice(Notice n) {
		// TODO Auto-generated method stub
		return nRepository.addNotice(n);
	}

	@Override
	public int deleteNoticeByid(Integer noticeId) {
		
		return nRepository.deleteNoticeByid(noticeId);
	}

	@Override
	public int updateNotice(Notice n) {
		// TODO Auto-generated method stub
		return 0;
	}

}