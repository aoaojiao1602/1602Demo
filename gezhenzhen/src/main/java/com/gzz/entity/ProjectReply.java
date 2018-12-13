package com.gzz.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="projectreplytb")
public class ProjectReply {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：贴吧回复自动增长主键'")
	@JsonProperty(value ="id")
	private Integer projectReplyId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer projectReplyUid;
	@Column(length=200)
	private String projectReplyContent;
	@Column(columnDefinition="TIMESTAMP",nullable=false,insertable=false,updatable=false)
	private Timestamp projectReplyCreateTime;
	/*@Column(columnDefinition="int unsigned NOT NULL comment '备注：贴吧的id外键'")
	private Integer projectReplyProjectId;*/
	@JsonIgnore
	@ManyToOne(targetEntity = Project.class)
	@JoinColumn(name="projectReplyProjectId")
	private Project project;
	@OneToMany(mappedBy="projectReply",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<ProjectReplyGood> projectReplyGood=new ArrayList<>();
	@OneToMany(mappedBy="projectReply",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<ProjectReplyNotGood> projectReplyNotGood=new ArrayList<>();
	@OneToMany(mappedBy="projectReply",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<ReplyReport> replyReport =new ArrayList<>();
	@Transient
	private Integer Exet1;
	@Transient
	private String Exet2;
	public Integer getProjectReplyId() {
		return projectReplyId;
	}
	public void setProjectReplyId(Integer projectReplyId) {
		this.projectReplyId = projectReplyId;
	}
	public Integer getProjectReplyUid() {
		return projectReplyUid;
	}
	public void setProjectReplyUid(Integer projectReplyUid) {
		this.projectReplyUid = projectReplyUid;
	}
	public String getProjectReplyContent() {
		return projectReplyContent;
	}
	public void setProjectReplyContent(String projectReplyContent) {
		this.projectReplyContent = projectReplyContent;
	}
	public Timestamp getProjectReplyCreateTime() {
		return projectReplyCreateTime;
	}
	public void setProjectReplyCreateTime(Timestamp projectReplyCreateTime) {
		this.projectReplyCreateTime = projectReplyCreateTime;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public List<ProjectReplyGood> getProjectReplyGood() {
		return projectReplyGood;
	}
	public void setProjectReplyGood(List<ProjectReplyGood> projectReplyGood) {
		this.projectReplyGood = projectReplyGood;
	}
	public List<ProjectReplyNotGood> getProjectReplyNotGood() {
		return projectReplyNotGood;
	}
	public void setProjectReplyNotGood(List<ProjectReplyNotGood> projectReplyNotGood) {
		this.projectReplyNotGood = projectReplyNotGood;
	}
	public List<ReplyReport> getReplyReport() {
		return replyReport;
	}
	public void setReplyReport(List<ReplyReport> replyReport) {
		this.replyReport = replyReport;
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
