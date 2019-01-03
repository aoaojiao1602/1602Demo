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

//回复踩帖表
@Entity
@Table(name="postbarReplyNotGoodtb")
public class PostbarReplyNotGood {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '回复踩贴ID'")
	@JsonProperty(value ="id")
	private Integer postbarReplyNotGoodId;
	@JsonIgnore
	@ManyToOne(targetEntity = PostbarReply.class)
	@JoinColumn(name="postbar_reply_not_good_postbar_reply_id")
	private PostbarReply postbarReply;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer uId;
	public Integer getPostbarReplyNotGoodId() {
		return postbarReplyNotGoodId;
	}
	public void setPostbarReplyNotGoodId(Integer postbarReplyNotGoodId) {
		this.postbarReplyNotGoodId = postbarReplyNotGoodId;
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
