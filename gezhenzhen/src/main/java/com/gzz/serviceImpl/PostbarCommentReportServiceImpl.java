package com.gzz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.repository.PostbarCommentReportRepository;
import com.gzz.service.PostbarCommentReportService;

@Service
public class PostbarCommentReportServiceImpl implements PostbarCommentReportService {
	
	@Autowired
	private PostbarCommentReportRepository postbarCommentReportRepository;
	@Override
	public int putPostbarCommentReport(Integer uId, Integer postbarCommentReportPostbarCommentId,
			String postbarCommentReportContent) {
		// TODO Auto-generated method stub
		return postbarCommentReportRepository.putPostbarCommentReport(uId, postbarCommentReportPostbarCommentId, postbarCommentReportContent);
	}

}
