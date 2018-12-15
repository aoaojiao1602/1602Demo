package com.gzz.service;

public interface ReplyServive {
	//对某个主题进行回复(相当于添加数据)
	public int putReply(String replyContent,Integer replyUid,Integer projectId);
}
