package com.gzz.service;

import org.springframework.data.domain.Page;

import com.gzz.entity.ProjectReply;

public interface ReplyServive {
	//对某个主题进行回复(相当于添加数据)
	public int putReply(String replyContent,Integer replyUid,Integer projectId);
	//删除评论
	public int deleteComment(Integer replyId);
	//删除回复
	public int deleteReply(Integer replyId);
	//查询对某一个主题的回复
	public Page<ProjectReply> getReplyPage(Integer projectId,Integer page,Integer size);
}
