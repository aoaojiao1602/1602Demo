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

//评论表
@Entity
@Table(name="postbarCommenttb")
public class PostbarComment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '评论ID'")
	@JsonProperty(value ="id")
	private Integer postbarCommentId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer uId;
	@JsonIgnore
	@ManyToOne(targetEntity = PostbarReply.class)
	@JoinColumn(name="postbar_comment_postbar_reply_id")
	private PostbarReply postbarReply;
	@Column(length=200)
	private String postbarCommentContent;
	@CreationTimestamp
	@Column(columnDefinition="timestamp comment '创建时间'",nullable=false,insertable=false,updatable=false)
	private Timestamp postbarCommentCreateTime;
	@OneToMany(mappedBy="postbarComment",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<PostbarCommentGood> postbarCommentGood=new ArrayList<>();
	@OneToMany(mappedBy="postbarComment",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<PostbarCommentNotGood> postbarCommentNotGood=new ArrayList<>();
	@OneToMany(mappedBy="postbarComment",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<PostbarCommentReport> postbarCommentReport=new ArrayList<>();
	public Integer getPostbarCommentId() {
		return postbarCommentId;
	}
	public void setPostbarCommentId(Integer postbarCommentId) {
		this.postbarCommentId = postbarCommentId;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public PostbarReply getPostbarReply() {
		return postbarReply;
	}
	public void setPostbarReply(PostbarReply postbarReply) {
		this.postbarReply = postbarReply;
	}
	public String getPostbarCommentContent() {
		return postbarCommentContent;
	}
	public void setPostbarCommentContent(String postbarCommentContent) {
		this.postbarCommentContent = postbarCommentContent;
	}
	public Timestamp getPostbarCommentCreateTime() {
		return postbarCommentCreateTime;
	}
	public void setPostbarCommentCreateTime(Timestamp postbarCommentCreateTime) {
		this.postbarCommentCreateTime = postbarCommentCreateTime;
	}
	public List<PostbarCommentGood> getPostbarCommentGood() {
		return postbarCommentGood;
	}
	public void setPostbarCommentGood(List<PostbarCommentGood> postbarCommentGood) {
		this.postbarCommentGood = postbarCommentGood;
	}
	public List<PostbarCommentNotGood> getPostbarCommentNotGood() {
		return postbarCommentNotGood;
	}
	public void setPostbarCommentNotGood(List<PostbarCommentNotGood> postbarCommentNotGood) {
		this.postbarCommentNotGood = postbarCommentNotGood;
	}
	public List<PostbarCommentReport> getPostbarCommentReport() {
		return postbarCommentReport;
	}
	public void setPostbarCommentReport(List<PostbarCommentReport> postbarCommentReport) {
		this.postbarCommentReport = postbarCommentReport;
	}
	
}
