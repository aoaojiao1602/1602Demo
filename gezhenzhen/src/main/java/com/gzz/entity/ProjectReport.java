package com.gzz.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="projectreporttb")
public class ProjectReport {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：贴吧举报自动增长主键'")
	@JsonProperty(value ="id")
	private Integer projectReportId;
	@JsonIgnore
	@ManyToOne(targetEntity = Project.class)
	@JoinColumn(name="projectReportProjectId")
	private Project project;
	/*@Column(columnDefinition="int unsigned NOT NULL comment '备注：贴吧表的id外键'")
	private Integer projectReportProjectId;*/
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer projectReportUid;
	@Column(length=100)
	private String  projectReportContent;
	@Column(columnDefinition="TIMESTAMP",nullable=false,insertable=false,updatable=false)
	private Timestamp projectReportTime;
	@Transient
	private Integer Exet1;
	@Transient
	private String Exet2;
	public Integer getProjectReportId() {
		return projectReportId;
	}
	public void setProjectReportId(Integer projectReportId) {
		this.projectReportId = projectReportId;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public Integer getProjectReportUid() {
		return projectReportUid;
	}
	public void setProjectReportUid(Integer projectReportUid) {
		this.projectReportUid = projectReportUid;
	}
	public String getProjectReportContent() {
		return projectReportContent;
	}
	public void setProjectReportContent(String projectReportContent) {
		this.projectReportContent = projectReportContent;
	}
	public Timestamp getProjectReportTime() {
		return projectReportTime;
	}
	public void setProjectReportTime(Timestamp projectReportTime) {
		this.projectReportTime = projectReportTime;
	}
	public Integer getExet1() {
		return Exet1;
	}
	public void setExet1(Integer exet1) {
		Exet1 = exet1;
	}
	public String getExet2() {
		return Exet2;
	}
	public void setExet2(String exet2) {
		Exet2 = exet2;
	}


}
