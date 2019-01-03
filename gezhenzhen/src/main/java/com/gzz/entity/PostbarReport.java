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

//贴吧举报表
@Entity
@Table(name="postbarReporttb")
public class PostbarReport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '贴吧举报ID'")
	@JsonProperty(value ="id")
	private Integer postbarReportId;
	@JsonIgnore
	@ManyToOne(targetEntity = Postbar.class)
	@JoinColumn(name="Postbar_report_postbar_id")
	private Postbar postbar;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer uId;
	@Column(length=200)
	private String postbarReportContent;
	@CreationTimestamp
	@Column(columnDefinition="timestamp comment '创建时间'",nullable=false,insertable=false,updatable=false)
	private Timestamp postbarReplyReportCreateTime;
	public Integer getPostbarReportId() {
		return postbarReportId;
	}
	public void setPostbarReportId(Integer postbarReportId) {
		this.postbarReportId = postbarReportId;
	}
	public Postbar getPostbar() {
		return postbar;
	}
	public void setPostbar(Postbar postbar) {
		this.postbar = postbar;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getPostbarReportContent() {
		return postbarReportContent;
	}
	public void setPostbarReportContent(String postbarReportContent) {
		this.postbarReportContent = postbarReportContent;
	}
	public Timestamp getPostbarReplyReportCreateTime() {
		return postbarReplyReportCreateTime;
	}
	public void setPostbarReplyReportCreateTime(Timestamp postbarReplyReportCreateTime) {
		this.postbarReplyReportCreateTime = postbarReplyReportCreateTime;
	}
	
}
