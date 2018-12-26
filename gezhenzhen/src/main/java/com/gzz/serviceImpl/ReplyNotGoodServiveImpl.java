package com.gzz.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.repository.ReplyNotGoodReopsitory;
import com.gzz.service.ReplyNotGoodServive;
@Service
public class ReplyNotGoodServiveImpl implements ReplyNotGoodServive {
	@Autowired
	private ReplyNotGoodReopsitory repository;
	//对回复进行点踩，查询当前用户是否对该回复进行了点踩
	@Transactional
	public int getReplyNotGood(Integer replyNotGoodReplyId, Integer replyNotGoodUid) {
		return repository.getReplyNotGood(replyNotGoodReplyId, replyNotGoodUid);
	}
	//如果该用户对该回复进行了点踩则再次操作是取消点踩

	@Transactional
	public int deleteReplyNotGood(Integer replyNotGoodReplyId, Integer replyNotGoodUid) {
		return repository.deleteReplyNotGood(replyNotGoodReplyId, replyNotGoodUid);
	}
	//如果该用户对该回复没有进行了点踩则进行点踩
	@Transactional
	public int putReplyNotGood(Integer replyNotGoodReplyId, Integer replyNotGoodUid) {
		return repository.putReplyNotGood(replyNotGoodReplyId, replyNotGoodUid);
	}
	//查询当前用户有没有对该回复进行点赞
	@Transactional
	 public int getReplyUid(Integer replyGoodUid,Integer replyId) {
		 return repository.getReplyUid(replyGoodUid, replyId);
	 }

}
