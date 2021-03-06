package com.gzz.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.gzz.entity.ProjectReply;
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
	//删除评论
	@Transactional
	public int deleteComment(Integer replyId) {
		return repository.deleteComment(replyId);
	}
	//删除回复
	@Transactional
	public int deleteReply(Integer replyId) {
		return repository.deleteReply(replyId);
	}
	//查询对某一个主题的回复
	@Transactional
	public Page<ProjectReply> getReplyPage(Integer projectId,Integer page,Integer size){
		Pageable pageable=PageRequest.of(page, size);
		return repository.getReplyPage(projectId,pageable);
	}

}
