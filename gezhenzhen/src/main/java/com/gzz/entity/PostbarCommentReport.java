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

//评论举报表
@Entity
@Table(name="postbarCommentReporttb")
public class PostbarCommentReport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '评论举报ID'")
	@JsonProperty(value ="id")
	private Integer postbarCommentReportId;
	@JsonIgnore
	@ManyToOne(targetEntity = PostbarComment.class)
	@JoinColumn(name="postbar_comment_report_postbar_comment_id")
	private PostbarComment postbarComment;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer uId;
	@Column(length=200)
	private String postbarCommentReportContent;
	@CreationTimestamp
	@Column(columnDefinition="timestamp comment '创建时间'",nullable=false,insertable=false,updatable=false)
	private Timestamp postbarCommentReportCreateTime;
	public Integer getPostbarCommentReportId() {
		return postbarCommentReportId;
	}
	public void setPostbarCommentReportId(Integer postbarCommentReportId) {
		this.postbarCommentReportId = postbarCommentReportId;
	}
	public PostbarComment getPostbarComment() {
		return postbarComment;
	}
	public void setPostbarComment(PostbarComment postbarComment) {
		this.postbarComment = postbarComment;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getPostbarCommentReportContent() {
		return postbarCommentReportContent;
	}
	public void setPostbarCommentReportContent(String postbarCommentReportContent) {
		this.postbarCommentReportContent = postbarCommentReportContent;
	}
	public Timestamp getPostbarCommentReportCreateTime() {
		return postbarCommentReportCreateTime;
	}
	public void setPostbarCommentReportCreateTime(Timestamp postbarCommentReportCreateTime) {
		this.postbarCommentReportCreateTime = postbarCommentReportCreateTime;
	}
	
}
