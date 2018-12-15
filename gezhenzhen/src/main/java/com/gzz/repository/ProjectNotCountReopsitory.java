package com.gzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.gzz.entity.ProjectNotCount;

public interface ProjectNotCountReopsitory extends JpaRepository<ProjectNotCount, Integer>{
	//对主题进行点踩，查询当前用户是否对该主题进行点踩
	@Query(value="SELECT COUNT(*) FROM projectnotcounttb WHERE project_not_count_uid=?1 AND project_not_count_project_id=?2",nativeQuery=true)
	public int getProjectNotCountByUid(Integer projectNotCountUid,Integer projectNotCountProjectId);
	//如果该用户对该主题进行过点踩则再次操作时取消点踩
	@Query(value="DELETE FROM projectnotcounttb WHERE project_not_count_uid=?1 AND project_not_count_project_id=?2",nativeQuery=true)
	@Modifying
	public int deleteProjectNotCountByUid(Integer projectNotCountUid,Integer projectNotCountProjectId);
	//如果该用户对该主题没有进行过点踩则对该主题进行点踩
	@Query(value="INSERT INTO projectnotcounttb(project_not_count_uid,project_not_count_project_id) VALUE(?1,?2)",nativeQuery=true)
	@Modifying
	public int putProjectNotCount(Integer projectNotCountUid,Integer projectNotCountProjectId);

}
