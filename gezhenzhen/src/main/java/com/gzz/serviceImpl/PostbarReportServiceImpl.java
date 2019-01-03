package com.gzz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.repository.PostbarReportRepository;
import com.gzz.service.PostbarReportService;

@Service
public class PostbarReportServiceImpl implements PostbarReportService {
	
	@Autowired
	private PostbarReportRepository postbarReportRepository;
	
	@Override
	public int putPostbarReport(Integer uId, Integer postbarReportPostbarId, String postbarReportContent) {
		// TODO Auto-generated method stub
		return postbarReportRepository.putPostbarReport(uId, postbarReportPostbarId, postbarReportContent);
	}

}
