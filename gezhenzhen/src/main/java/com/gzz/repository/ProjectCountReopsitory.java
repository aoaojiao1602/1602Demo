package com.gzz.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.gzz.entity.Project;
import com.gzz.entity.ProjectCount;

public interface ProjectCountReopsitory extends JpaRepository<ProjectCount, Integer>{
	//查询当前用户有没有进行点踩
	@Query(value="SELECT COUNT(*) FROM projectnotcounttb where project_not_count_project_id=?1 AND project_not_count_uid=?2",nativeQuery=true)
	public int getUidCount(Integer projectId,Integer projectCountUids);
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
	//按照投票数进行查询
	/*@Query(value="SELECT projecttb.*,projectcounttb.sum FROM projecttb ,(SELECT *,COUNT(*) SUM FROM projectcounttb GROUP BY projectcounttb.project_count_project_id) projectcounttb  WHERE projecttb.project_id=projectcounttb.project_count_project_id ORDER BY projectcounttb.sum DESC",nativeQuery=true)
	public Page<Project> getProjectCount(Pageable pageable);*/

}
