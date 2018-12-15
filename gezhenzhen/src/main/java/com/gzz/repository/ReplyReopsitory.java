package com.gzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.gzz.entity.ProjectReply;

public interface ReplyReopsitory extends JpaRepository<ProjectReply, Integer>{
	//查询不用@Modifying注解
	//查询某个主题的最后回复
	//对某个主题进行回复(相当于添加数据)
	@Query(value="INSERT INTO projectreplytb(project_reply_content,project_reply_uid,project_reply_project_id) VALUE(?1,?2,?3)",nativeQuery=true)
	@Modifying
	public int putReply(String replyContent,Integer replyUid,Integer projectId);
	

}
