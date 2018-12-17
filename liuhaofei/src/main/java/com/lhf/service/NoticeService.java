package com.lhf.service;

import com.lhf.entity.Notice;

public interface NoticeService {
	//添加公告
	public int addNotice(Notice n);
	//删除公告
	public int deleteNoticeByid(Integer noticeId);
	//修改公告
	public int updateNotice(Notice n);
	
}