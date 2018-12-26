package com.gzz.serviceImpl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.repository.CommentReopsitory;
import com.gzz.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentReopsitory reopsitory;
	//对回复进行评论
	@Transactional
	public int putComment(Integer replyId,Integer commentUid,String commentContent) {
		return reopsitory.putComment(replyId, commentUid, commentContent);
	}
	//删除评论
	@Transactional
	public int  deleyeComment(Integer commentId) {
		return reopsitory.deleyeComment(commentId);
	}

}
