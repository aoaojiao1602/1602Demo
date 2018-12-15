package com.gzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.gzz.entity.ProjectCount;

public interface ProjectCountReopsitory extends JpaRepository<ProjectCount, Integer>{
	//对主题进行点赞
	@Query(value="INSERT INTO projectcounttb (project_count_project_id,project_count_uid) VALUE(?1,?2)",nativeQuery=true)
	@Modifying
	public int putProjectCount(Integer projectId,Integer projectCountUids);
	//查询当前用户有没有对该主题进行点赞
	@Query(value="SELECT COUNT(*) FROM projectcounttb WHERE  project_count_project_id=?1  AND project_count_uid=?2",nativeQuery=true)
	public int getUid(Integer projectId,Integer ProjectCountUids);
	//如果当前用户已经对该主题进行了点赞则进行取消点赞
	@Query(value="DELETE FROM projectcounttb WHERE project_count_uid=?1 AND project_count_project_id=?2",nativeQuery=true)
	@Modifying
	public int deleteProjectCount(Integer projectId,Integer ProjectCountUids);

}
