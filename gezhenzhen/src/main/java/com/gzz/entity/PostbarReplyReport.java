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

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

//回复举报表
@Entity
@Table(name="postbarReplyReporttb")
public class PostbarReplyReport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '回复举报ID'")
	@JsonProperty(value ="id")
	private Integer postbarReplyReportId;
	@JsonIgnore
	@ManyToOne(targetEntity = PostbarReply.class)
	@JoinColumn(name="postbar_reply_report_postbar_reply_id")
	private PostbarReply postbarReply;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer uId;
	@Column(length=200)
	private String postbarReplyReportContent;
	@CreationTimestamp
	@Column(columnDefinition="timestamp comment '创建时间'",nullable=false,insertable=false,updatable=false)
	private Timestamp postbarReplyReportCreateTime;
	public Integer getPostbarReplyReportId() {
		return postbarReplyReportId;
	}
	public void setPostbarReplyReportId(Integer postbarReplyReportId) {
		this.postbarReplyReportId = postbarReplyReportId;
	}
	public PostbarReply getPostbarReply() {
		return postbarReply;
	}
	public void setPostbarReply(PostbarReply postbarReply) {
		this.postbarReply = postbarReply;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getPostbarReplyReportContent() {
		return postbarReplyReportContent;
	}
	public void setPostbarReplyReportContent(String postbarReplyReportContent) {
		this.postbarReplyReportContent = postbarReplyReportContent;
	}
	public Timestamp getPostbarReplyReportCreateTime() {
		return postbarReplyReportCreateTime;
	}
	public void setPostbarReplyReportCreateTime(Timestamp postbarReplyReportCreateTime) {
		this.postbarReplyReportCreateTime = postbarReplyReportCreateTime;
	}
	
}
