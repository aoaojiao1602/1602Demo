package com.gzz.entity;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="projecttb")
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：课程贴吧自动增长主键'")
	@JsonProperty(value ="id")
	private Integer projectId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer uId;	
	@JsonIgnore
	@ManyToOne(targetEntity = Module.class)
	@JoinColumn(name="projectModuleid")
	private Module module;
	/*@Column(columnDefinition="int unsigned NOT NULL comment '备注：模块的id外键'")
	private Integer projectModuleid;*/
	@Column(columnDefinition="int unsigned comment '备注：课件的id外键'")
	private Integer clazzId;
	@Column(columnDefinition="int DEFAULT 0 comment '备注：是否关注'")
	private Integer projectState;
	@Column(length=50)
	private String projectTitle;
	@Column(length=200)
	private String projectContent;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(locale="zh",timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
	private Date projectCreatetime;
	@Column(columnDefinition="TIMESTAMP",nullable=false,insertable=false,updatable=false)
	private Timestamp projectLastTime;
	@OneToMany(mappedBy="project",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<ProjectReply> projectReply=new ArrayList<>();
	@OneToMany(mappedBy="project",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<ProjectCount> projectCount=new ArrayList<>();
	@OneToMany(mappedBy="project",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<ProjectNotCount> projectNotCountsCount=new ArrayList<>();
	@OneToMany(mappedBy="project",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<ProjectReport> projectReport =new ArrayList<>();
	@OneToMany(mappedBy="project",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Through> through =new ArrayList<>();
	@Transient
	private Integer Exet1;
	@Transient
	private String Exet2;
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public Integer getClazzId() {
		return clazzId;
	}
	public void setClazzId(Integer clazzId) {
		this.clazzId = clazzId;
	}
	public Integer getProjectState() {
		return projectState;
	}
	public void setProjectState(Integer projectState) {
		this.projectState = projectState;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getProjectContent() {
		return projectContent;
	}
	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}
	public Date getProjectCreatetime() {
		return projectCreatetime;
	}
	public void setProjectCreatetime(Date projectCreatetime) {
		this.projectCreatetime = projectCreatetime;
	}
	public Timestamp getProjectLastTime() {
		return projectLastTime;
	}
	public void setProjectLastTime(Timestamp projectLastTime) {
		this.projectLastTime = projectLastTime;
	}
	public List<ProjectReply> getProjectReply() {
		return projectReply;
	}
	public void setProjectReply(List<ProjectReply> projectReply) {
		this.projectReply = projectReply;
	}
	public List<ProjectCount> getProjectCount() {
		return projectCount;
	}
	public void setProjectCount(List<ProjectCount> projectCount) {
		this.projectCount = projectCount;
	}
	public List<ProjectNotCount> getProjectNotCountsCount() {
		return projectNotCountsCount;
	}
	public void setProjectNotCountsCount(List<ProjectNotCount> projectNotCountsCount) {
		this.projectNotCountsCount = projectNotCountsCount;
	}
	public List<ProjectReport> getProjectReport() {
		return projectReport;
	}
	public void setProjectReport(List<ProjectReport> projectReport) {
		this.projectReport = projectReport;
	}
	public List<Through> getThrough() {
		return through;
	}
	public void setThrough(List<Through> through) {
		this.through = through;
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
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", uId=" + uId + ", module=" + module + ", clazzId=" + clazzId
				+ ", projectState=" + projectState + ", projectTitle=" + projectTitle + ", projectContent="
				+ projectContent + ", projectCreatetime=" + projectCreatetime + ", projectLastTime=" + projectLastTime
				+ ", projectReply=" + projectReply + ", projectCount=" + projectCount + ", projectNotCountsCount="
				+ projectNotCountsCount + ", projectReport=" + projectReport + ", through=" + through + ", Exet1="
				+ Exet1 + ", Exet2=" + Exet2 + "]";
	}
	
}
