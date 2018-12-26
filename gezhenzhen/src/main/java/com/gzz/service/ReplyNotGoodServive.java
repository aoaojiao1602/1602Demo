package com.gzz.service;

public interface ReplyNotGoodServive {
	//查询当前用户有没有对该回复进行点赞
	public int getReplyUid(Integer replyGoodUid,Integer replyId);
	//对回复进行点踩，查询当前用户是否对该回复进行了点踩
	public int getReplyNotGood(Integer replyNotGoodReplyId,Integer replyNotGoodUid);
	//如果该用户对该回复进行了点踩则再次操作是取消点踩
	public int deleteReplyNotGood(Integer replyNotGoodReplyId,Integer replyNotGoodUid);
	//如果该用户对该回复没有进行了点踩则进行点踩
	public int putReplyNotGood(Integer replyNotGoodReplyId,Integer replyNotGoodUid);

}
