package com.gzz.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.repository.ReplyReportRepository;
import com.gzz.service.ReplyReportServive;
@Service
public class ReplyReportServiveImpl implements ReplyReportServive {
	@Autowired 
	private ReplyReportRepository repository;
	@Transactional		
	public int putReplyRepotr(Integer reportUid,Integer replyId,String reportContent) {
		return repository.putReplyRepotr(reportUid, replyId, reportContent);
	}

}
