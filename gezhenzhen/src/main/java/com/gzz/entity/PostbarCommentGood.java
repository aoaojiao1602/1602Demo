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

//评论顶贴表
@Entity
@Table(name="postbarCommentGoodtb")
public class PostbarCommentGood {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '评论顶贴ID'")
	@JsonProperty(value ="id")
	private Integer postbarCommentGoodId;
	@JsonIgnore
	@ManyToOne(targetEntity = PostbarComment.class)
	@JoinColumn(name="postbar_comment_good_postbar_comment_id")
	private PostbarComment postbarComment;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer uId;
	public Integer getPostbarCommentGoodId() {
		return postbarCommentGoodId;
	}
	public void setPostbarCommentGoodId(Integer postbarCommentGoodId) {
		this.postbarCommentGoodId = postbarCommentGoodId;
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
