package com.gzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.gzz.entity.ProjectReplyNotGood;

public interface ReplyNotGoodReopsitory extends JpaRepository<ProjectReplyNotGood, Integer>{
	//查询当前用户有没有对该回复进行点赞
    @Query(value="SELECT COUNT(*) FROM projectreplygoodtb WHERE project_reply_good_uid=?1 AND project_reply_good_project_reply_id=?2",nativeQuery=true)
    public int getReplyUid(Integer replyGoodUid,Integer replyId);
	//对回复进行点踩，查询当前用户是否对该回复进行了点踩
	@Query(value="SELECT COUNT(*) FROM projectreplynotgoodtb WHERE project_reply_not_good_project_reply_id=?1 AND project_reply_not_good_uid=?2",nativeQuery=true)
	public int getReplyNotGood(Integer replyNotGoodReplyId,Integer replyNotGoodUid);
	//如果该用户对该回复进行了点踩则再次操作是取消点踩
	@Query(value="DELETE FROM projectreplynotgoodtb WHERE project_reply_not_good_project_reply_id=?1 AND project_reply_not_good_uid=?2",nativeQuery=true)
	@Modifying
	public int deleteReplyNotGood(Integer replyNotGoodReplyId,Integer replyNotGoodUid);
	//如果该用户对该回复没有进行了点踩则进行点踩
	@Query(value="INSERT INTO projectreplynotgoodtb(project_reply_not_good_project_reply_id,project_reply_not_good_uid) VALUE(?1,?2)",nativeQuery=true)
	@Modifying
	public int putReplyNotGood(Integer replyNotGoodReplyId,Integer replyNotGoodUid);
	
	

}
