package com.gzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.gzz.entity.CommentNotGrate;

public interface CommentNotGrateReopsitory extends JpaRepository<CommentNotGrate, Integer>{
	//查询当前用户有没有对该评论进行点踩
	@Query(value="SELECT COUNT(*) FROM commentgratetb WHERE comment_grate_comment_id=?1 AND comment_grate_uid=?2",nativeQuery=true)
	public int getComment(Integer commentId,Integer commentUid);
	//查询当前用户有没有对该评论进行点赞
	@Query(value="SELECT COUNT(*) FROM commentnotgratetb WHERE comment_not_grate_comment_id=?1 AND comment_not_grate_uid=?2",nativeQuery=true)
	public int getCommentByUid(Integer commentId,Integer commentUid);
	//如果该用户对评论进行过点赞则再次操作是取消点赞
	@Query(value="DELETE FROM commentnotgratetb WHERE comment_not_grate_comment_id=?1 AND comment_not_grate_uid=?2",nativeQuery=true)
	@Modifying
	public int deleteCommentGrate(Integer commentId,Integer commentUid);
	//对该评论进行点赞
	@Query(value="INSERT INTO commentnotgratetb(comment_not_grate_comment_id,comment_not_grate_uid) VALUE(?1,?2)",nativeQuery=true)
	@Modifying
	public int putCommentGrate(Integer commentId,Integer commentUid);
	
	

}
