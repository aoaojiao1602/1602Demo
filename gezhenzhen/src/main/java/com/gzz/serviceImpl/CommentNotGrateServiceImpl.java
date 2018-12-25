package com.gzz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gzz.repository.CommentNotGrateReopsitory;
import com.gzz.service.CommentNotGrateService;
@Service
public class CommentNotGrateServiceImpl implements CommentNotGrateService {
	@Autowired
	private CommentNotGrateReopsitory reopsitory;
	//查询当前用户有没有对该评论进行点踩
	public int getComment(Integer commentId,Integer commentUid) {
		return reopsitory.getComment(commentId, commentUid);
	}
	//查询当前用户有没有对该评论进行点赞
	public int getCommentByUid(Integer commentId,Integer commentUid) {
		return reopsitory.getCommentByUid(commentId, commentUid);
	}
	//对该评论进行点赞
	public int deleteCommentGrate(Integer commentId,Integer commentUid) {
		return reopsitory.deleteCommentGrate(commentId, commentUid);
	}
	//如果该用户对评论进行过点赞则再次操作是取消点赞
	public int putCommentGrate(Integer commentId,Integer commentUid) {
		return reopsitory.putCommentGrate(commentId, commentUid);
	}
}
