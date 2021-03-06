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
@Table(name="projectreplynotgoodtb")
public class ProjectReplyNotGood {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：回复点踩自动增长主键'")
	@JsonProperty(value ="id")
	private Integer ProjectReplyNotGoodId;
	@JsonIgnore
	@ManyToOne(targetEntity = ProjectReply.class)
	@JoinColumn(name="ProjectReplyNotGoodProjectReplyId")
	private ProjectReply projectReply;
	/*@Column(columnDefinition="int unsigned NOT NULL comment '备注：回复表的id外键'")
	private Integer ProjectReplyNotGoodProjectReplyId;*/
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer ProjectReplyNotGoodUid;
	@Transient
	private Integer Exet1;
	@Transient
	private String Exet2;
	public Integer getProjectReplyNotGoodId() {
		return ProjectReplyNotGoodId;
	}
	public void setProjectReplyNotGoodId(Integer projectReplyNotGoodId) {
		ProjectReplyNotGoodId = projectReplyNotGoodId;
	}
	public ProjectReply getProjectReply() {
		return projectReply;
	}
	public void setProjectReply(ProjectReply projectReply) {
		this.projectReply = projectReply;
	}
	public Integer getProjectReplyNotGoodUid() {
		return ProjectReplyNotGoodUid;
	}
	public void setProjectReplyNotGoodUid(Integer projectReplyNotGoodUid) {
		ProjectReplyNotGoodUid = projectReplyNotGoodUid;
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
