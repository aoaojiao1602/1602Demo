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

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

//回复表
@Entity
@Table(name="postbarReplytb")
public class PostbarReply {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '回复ID'")
	@JsonProperty(value ="id")
	private Integer postbarReplyId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer uId;
	@JsonIgnore
	@ManyToOne(targetEntity = Postbar.class)
	@JoinColumn(name="postbar_reply_postbar_id")
	private Postbar postbar;
	@Column(length=200)
	private String postbarReplyContent;
	@CreationTimestamp
	@Column(columnDefinition="timestamp comment '创建时间'",nullable=false,insertable=false,updatable=false)
	private Timestamp postbarReplyCreateTime;
	@OneToMany(mappedBy="postbarReply",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<PostbarReplyGood> postbarReplyGood=new ArrayList<>();
	@OneToMany(mappedBy="postbarReply",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<PostbarReplyNotGood> postbarReplyNotGood=new ArrayList<>();
	@OneToMany(mappedBy="postbarReply",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<PostbarReplyReport> postbarReplyReport=new ArrayList<>();
	@OneToMany(mappedBy="postbarReply",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<PostbarComment> postbarComment=new ArrayList<>();
	public Integer getPostbarReplyId() {
		return postbarReplyId;
	}
	public void setPostbarReplyId(Integer postbarReplyId) {
		this.postbarReplyId = postbarReplyId;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public Postbar getPostbar() {
		return postbar;
	}
	public void setPostbar(Postbar postbar) {
		this.postbar = postbar;
	}
	public String getPostbarReplyContent() {
		return postbarReplyContent;
	}
	public void setPostbarReplyContent(String postbarReplyContent) {
		this.postbarReplyContent = postbarReplyContent;
	}
	public Timestamp getPostbarReplyCreateTime() {
		return postbarReplyCreateTime;
	}
	public void setPostbarReplyCreateTime(Timestamp postbarReplyCreateTime) {
		this.postbarReplyCreateTime = postbarReplyCreateTime;
	}
	public List<PostbarReplyGood> getPostbarReplyGood() {
		return postbarReplyGood;
	}
	public void setPostbarReplyGood(List<PostbarReplyGood> postbarReplyGood) {
		this.postbarReplyGood = postbarReplyGood;
	}
	public List<PostbarReplyNotGood> getPostbarReplyNotGood() {
		return postbarReplyNotGood;
	}
	public void setPostbarReplyNotGood(List<PostbarReplyNotGood> postbarReplyNotGood) {
		this.postbarReplyNotGood = postbarReplyNotGood;
	}
	public List<PostbarReplyReport> getPostbarReplyReport() {
		return postbarReplyReport;
	}
	public void setPostbarReplyReport(List<PostbarReplyReport> postbarReplyReport) {
		this.postbarReplyReport = postbarReplyReport;
	}
	public List<PostbarComment> getPostbarComment() {
		return postbarComment;
	}
	public void setPostbarComment(List<PostbarComment> postbarComment) {
		this.postbarComment = postbarComment;
	}
	
}
