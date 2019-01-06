package com.gzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.gzz.entity.ProjectReplyGood;

public interface ReplyGoodReopsitory extends JpaRepository<ProjectReplyGood, Integer> {
	//查询当前用户有没有对该回复进行点踩
    @Query(value="SELECT COUNT(*) FROM projectreplynotgoodtb WHERE  project_reply_not_good_uid=?1 AND project_reply_not_good_project_reply_id=?2",nativeQuery=true)
    public int getReplyUids(Integer replyGoodUid,Integer replyId);
	// 对回复进行点赞，查询当前用户有没有对该帖子进行点赞
	@Query(value = "SELECT COUNT(*) FROM projectreplygoodtb WHERE project_reply_good_uid=?1 AND project_reply_good_project_reply_id=?2", nativeQuery = true)
	public int getReplyByUid(Integer replyGoodUid,Integer replyId);
	// 如果点赞则再次操作是取消点赞
	@Query(value = "DELETE FROM projectreplygoodtb WHERE project_reply_good_uid=?1 AND project_reply_good_project_reply_id=?2", nativeQuery = true)
	@Modifying
	public int deleteReplyByUid(Integer replyGoodUid,Integer replyId);
	// 如果没有进行点赞则进行点赞
	@Query(value = "INSERT INTO projectreplygoodtb (project_reply_good_uid,project_reply_good_project_reply_id) VALUE(?1,?2)", nativeQuery = true)
	@Modifying
	public int putReplyGood(Integer replyGoodUid,Integer replyId);

}
