package com.gzz.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.repository.ReplyReopsitory;
import com.gzz.service.ReplyServive;
@Service
public class ReplyServiveImpl implements ReplyServive {
	@Autowired
	private ReplyReopsitory repository;
	//对某个主题进行回复(相当于添加数据)
	@Transactional
	public int putReply(String replyContent, Integer replyUid, Integer projectId) {
		return repository.putReply(replyContent, replyUid, projectId);
	}
	

}
