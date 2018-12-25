package com.gzz.service;

public interface CommentNotGrateService {
	//查询当前用户有没有对该评论进行点踩
	public int getComment(Integer commentId,Integer commentUid);
	//查询当前用户有没有对该评论进行点赞
	public int getCommentByUid(Integer commentId,Integer commentUid);
	//对该评论进行点赞
	public int deleteCommentGrate(Integer commentId,Integer commentUid);
	//如果该用户对评论进行过点赞则再次操作是取消点赞
	public int putCommentGrate(Integer commentId,Integer commentUid);

}
