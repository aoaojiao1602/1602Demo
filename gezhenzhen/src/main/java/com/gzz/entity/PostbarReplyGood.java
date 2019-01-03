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

//回复顶贴表
@Entity
@Table(name="postbarReplyGoodtb")
public class PostbarReplyGood {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '回复顶贴ID'")
	@JsonProperty(value ="id")
	private Integer postbarReplyGoodId;
	@JsonIgnore
	@ManyToOne(targetEntity = PostbarReply.class)
	@JoinColumn(name="postbar_reply_good_postbar_reply_id")
	private PostbarReply postbarReply;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer uId;
	public Integer getPostbarReplyGoodId() {
		return postbarReplyGoodId;
	}
	public void setPostbarReplyGoodId(Integer postbarReplyGoodId) {
		this.postbarReplyGoodId = postbarReplyGoodId;
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
	
}
