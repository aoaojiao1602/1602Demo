package com.gzz.service;

public interface CommentService {
	//对回复进行评论
	public int putComment(Integer replyId,Integer commentUid,String commentContent);
	//删除评论
	public int  deleyeComment(Integer commentId);

}
