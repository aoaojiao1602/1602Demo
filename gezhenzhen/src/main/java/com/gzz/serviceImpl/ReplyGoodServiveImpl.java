package com.gzz.serviceImpl;

import javax.transaction.Transactional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.repository.ReplyGoodReopsitory;
import com.gzz.service.ReplyGoodServive;
@Service
public class ReplyGoodServiveImpl implements ReplyGoodServive {
	@Autowired
	private ReplyGoodReopsitory reopsitory;
	@Transactional
	public int getReplyByUid(Integer replyGoodUid, Integer replyId) {
		return reopsitory.getReplyByUid(replyGoodUid, replyId);
	}

	@Transactional
	public int deleteReplyByUid(Integer replyGoodUid, Integer replyId) {
		return reopsitory.deleteReplyByUid(replyGoodUid, replyId);
	}

	@Transactional
	public int putReplyGood(Integer replyGoodUid, Integer replyId) {
		return reopsitory.putReplyGood(replyGoodUid, replyId);
	}
	@Transactional
	//查询当前用户有没有对该回复进行点踩
	 public int getReplyUids(Integer replyGoodUid,Integer replyId) {
		return reopsitory.getReplyUids(replyGoodUid, replyId);
	}

}
