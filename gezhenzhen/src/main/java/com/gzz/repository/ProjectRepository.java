package com.gzz.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.gzz.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{
	//修改自己所发表的主题
	@Query(value="UPDATE projecttb SET project_title=?1,project_content=?2 WHERE project_id=?3",nativeQuery=true)
	@Modifying
	public int postProject(String projectTitle,String projectContent,Integer projectId);
	//发表主题(所属的讨论区模块是老师答疑区)
	@Query(value="INSERT INTO projecttb (clazz_id,project_content,project_createtime,project_title,u_id,project_moduleid) VALUE(?1,?2,?3,?4,?5,?6)",nativeQuery=true)
	@Modifying
	public int putProject(Integer clazzId,String projectContent,String projectCreatetime,String projectTitle,Integer projectUid,Integer moduleId);
	//发表主题(所属的讨论区模块是综合讨论区)
	@Query(value="INSERT INTO projecttb (project_content,project_createtime,project_title,u_id,project_moduleid) VALUE(?1,?2,?3,?4,?5)",nativeQuery=true)
	@Modifying
	public int putProjects(String projectContent,String projectCreatetime,String projectTitle,Integer projectUid,Integer moduleId);
	//查询用户自己所关注的主题
	@Query(value="SELECT * FROM projecttb WHERE project_state=?1 AND u_id=?2",nativeQuery=true)
	public List<Project> getProjectByProjectState(Integer projectState,Integer uId);
}
