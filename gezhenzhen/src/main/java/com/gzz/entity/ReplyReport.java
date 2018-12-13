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
@Table(name="replyreporttb")
public class ReplyReport {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：回复举报自动增长主键'")
	@JsonProperty(value ="id")
	private Integer ReplyReportId;
	@JsonIgnore
	@ManyToOne(targetEntity = ProjectReply.class)
	@JoinColumn(name="ReplyReportReplyId")
	private ProjectReply projectReply;
	/*@Column(columnDefinition="int unsigned NOT NULL comment '备注：回复表的id外键'")
	private Integer ReplyReportReplyId;*/
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer  ReplyReportUid;
	@Column(length=100)
	private String  ReplyReportContent;
	@Column(columnDefinition="TIMESTAMP",nullable=false,insertable=false,updatable=false)
	private Timestamp ReplyReportTime;
	@Transient
	private Integer Exet1;
	@Transient
	private String Exet2;
	public Integer getReplyReportId() {
		return ReplyReportId;
	}
	public void setReplyReportId(Integer replyReportId) {
		ReplyReportId = replyReportId;
	}
	public ProjectReply getProjectReply() {
		return projectReply;
	}
	public void setProjectReply(ProjectReply projectReply) {
		this.projectReply = projectReply;
	}
	public Integer getReplyReportUid() {
		return ReplyReportUid;
	}
	public void setReplyReportUid(Integer replyReportUid) {
		ReplyReportUid = replyReportUid;
	}
	public String getReplyReportContent() {
		return ReplyReportContent;
	}
	public void setReplyReportContent(String replyReportContent) {
		ReplyReportContent = replyReportContent;
	}
	public Timestamp getReplyReportTime() {
		return ReplyReportTime;
	}
	public void setReplyReportTime(Timestamp replyReportTime) {
		ReplyReportTime = replyReportTime;
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
