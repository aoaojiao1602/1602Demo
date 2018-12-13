package com.gzz.entity;

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
@Table(name="commentgratetb")
public class CommentGrate {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：评论点赞表自动增长主键'")
	@JsonProperty(value ="id")
	private Integer CommentGrateId;
	@JsonIgnore
	@ManyToOne(targetEntity = ProjectReply.class)
	@JoinColumn(name="CommentGrateCommentId")
	private Comment comment;
/*	@Column(columnDefinition="int unsigned NOT NULL comment '备注：评论表id外键'")
	private Integer CommentGrateCommentId;*/
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer CommentGrateUid;
	@Transient
	private Integer Exet1;
	@Transient
	private String Exet2;
	public Integer getCommentGrateId() {
		return CommentGrateId;
	}
	public void setCommentGrateId(Integer commentGrateId) {
		CommentGrateId = commentGrateId;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public Integer getCommentGrateUid() {
		return CommentGrateUid;
	}
	public void setCommentGrateUid(Integer commentGrateUid) {
		CommentGrateUid = commentGrateUid;
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
