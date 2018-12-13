package com.gzz.entity;

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
@Table(name="projectcounttb")
public class ProjectCount {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：课程点赞自动增长主键'")
	@JsonProperty(value = "id")
	private Integer projectCountId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer projectCountUid;
	@JsonIgnore
	@ManyToOne(targetEntity = Project.class)
	@JoinColumn(name="projectCountProjectId")
	private Project project;
	/*@Column(columnDefinition="int unsigned NOT NULL comment '备注：课程贴吧的id外键'")
	private Integer projectCountProjectId;*/
	@Transient
	private Integer Exet1;
	@Transient
	private String Exet2;
	public Integer getProjectCountId() {
		return projectCountId;
	}
	public void setProjectCountId(Integer projectCountId) {
		this.projectCountId = projectCountId;
	}
	public Integer getProjectCountUid() {
		return projectCountUid;
	}
	public void setProjectCountUid(Integer projectCountUid) {
		this.projectCountUid = projectCountUid;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
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
