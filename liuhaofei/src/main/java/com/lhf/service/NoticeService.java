package com.lhf.service;

import org.springframework.data.domain.Page;

import com.lhf.entity.Notice;
import com.lhf.entity.NoticeSearch;

public interface NoticeService {
	//分页查询课程
	public Page<Notice> queryByDynamicSQLPage(NoticeSearch n,Integer page,Integer size);
	//添加公告
	public int putNotice(Notice n);
	//删除公告
	public int deleteNoticeByid(Integer noticeId);
	//修改公告
	public int postNotice(Notice n);
	
}