package com.gzz.service;

public interface CommentGrateService {
	//查询当前用户有没有对该评论进行点踩
	public int getNotComment(Integer commentId,Integer commentUid);
	//查询当前用户有没有对该评论进行点赞
	public int getCommentByUid(Integer commentId,Integer commentUid);
	//如果该用户对评论进行过点赞则再次操作是取消点赞
	public int deleteComment(Integer commentId,Integer commentUid);
	//对该评论进行点赞
	public int putComments(Integer commentId,Integer commentUid);

}
