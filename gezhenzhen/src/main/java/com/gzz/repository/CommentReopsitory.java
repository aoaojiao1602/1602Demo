package com.gzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.gzz.entity.Comment;

public interface CommentReopsitory extends JpaRepository<Comment, Integer>{
	//对回复进行评论
	@Query(value="INSERT INTO commenttb (comment_reply_id,comment_uid,comment_content) VALUE(?1,?2,?3)",nativeQuery=true)
	@Modifying
	public int putComment(Integer replyId,Integer commentUid,String commentContent);
	//删除评论
	@Query(value="DELETE FROM commenttb WHERE comment_id=?1",nativeQuery=true)
	@Modifying
	public int  deleyeComment(Integer commentId);

}
