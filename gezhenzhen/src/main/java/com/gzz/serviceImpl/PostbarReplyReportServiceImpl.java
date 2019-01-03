package com.gzz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.repository.PostbarReplyReportRepository;
import com.gzz.service.PostbarReplyReportService;

@Service
public class PostbarReplyReportServiceImpl implements PostbarReplyReportService {
	
	@Autowired
	private PostbarReplyReportRepository postbarReplyReportRepository;
	@Override
	public int putPostbarReplyReport(Integer uId, Integer postbarReplyReportPostbarReplyId,
			String postbarReplyReportContent) {
		// TODO Auto-generated method stub
		return postbarReplyReportRepository.putPostbarReplyReport(uId, postbarReplyReportPostbarReplyId, postbarReplyReportContent);
	}

}
