package com.gzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.gzz.entity.ProjectReport;

public interface ProjectReoprtRepository extends JpaRepository<ProjectReport, Integer>{
	//对主题进行举报
	@Query(value="INSERT INTO projectreporttb(project_report_content,project_report_uid,project_report_project_id)VALUE(?1,?2,?3)",nativeQuery=true)
	@Modifying
	public int putProjectReport(String reportContent,Integer reportUid,Integer projectId);

}
