package com.gzz.service;

public interface ReplyGoodServive {
	// 对回复进行点赞，查询当前用户有没有对该帖子进行点赞
	public int getReplyByUid(Integer replyGoodUid,Integer replyId);
	// 如果点赞则再次操作是取消点赞
	public int deleteReplyByUid(Integer replyGoodUid,Integer replyId);
	// 如果没有进行点赞则进行点赞
	public int putReplyGood(Integer replyGoodUid,Integer replyId);

}
