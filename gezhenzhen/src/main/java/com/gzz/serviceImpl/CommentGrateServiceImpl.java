package com.gzz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.repository.CommentGrateReopsitory;
import com.gzz.service.CommentGrateService;
@Service
public class CommentGrateServiceImpl implements CommentGrateService {
	@Autowired
	private CommentGrateReopsitory reopsitory;
	//查询当前用户有没有对该评论进行点踩
	public int getNotComment(Integer commentId,Integer commentUid) {
		return reopsitory.getNotComment(commentId, commentUid);
	}
	//查询当前用户有没有对该评论进行点赞
	public int getCommentByUid(Integer commentId,Integer commentUid) {
		return reopsitory.getCommentByUid(commentId, commentUid);
	}
	//如果该用户对评论进行过点赞则再次操作是取消点赞
	public int deleteComment(Integer commentId,Integer commentUid) {
		return reopsitory.deleteComment(commentId, commentUid);
	}
	//对该评论进行点赞
	public int putComments(Integer commentId,Integer commentUid) {
		return reopsitory.putComments(commentId, commentUid);
	}

}
