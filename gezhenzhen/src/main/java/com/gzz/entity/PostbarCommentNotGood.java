package com.gzz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

//评论踩帖表
@Entity
@Table(name="postbarCommentNotGoodtb")
public class PostbarCommentNotGood {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '评论踩贴ID'")
	@JsonProperty(value ="id")
	private Integer postbarCommentNotGoodId;
	@JsonIgnore
	@ManyToOne(targetEntity = PostbarComment.class)
	@JoinColumn(name="postbar_comment_not_good_postbar_comment_id")
	private PostbarComment postbarComment;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer uId;
	public Integer getPostbarCommentNotGoodId() {
		return postbarCommentNotGoodId;
	}
	public void setPostbarCommentNotGoodId(Integer postbarCommentNotGoodId) {
		this.postbarCommentNotGoodId = postbarCommentNotGoodId;
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
	
}
