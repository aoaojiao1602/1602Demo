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
@Table(name="commentnotgratetb")
public class CommentNotGrate {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：评论点踩表自动增长主键'")
	@JsonProperty(value ="id")
	private Integer CommentNotGrateId;
	@JsonIgnore
	@ManyToOne(targetEntity = ProjectReply.class)
	@JoinColumn(name="CommentNotGrateCommentId")
	private Comment comment;
	/*@Column(columnDefinition="int unsigned NOT NULL comment '备注：评论表id外键'")
	private Integer CommentNotGrateCommentId;*/
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer CommentNotGrateUid;
	@Transient
	private Integer Exet1;
	@Transient
	private String Exet2;
	public Integer getCommentNotGrateId() {
		return CommentNotGrateId;
	}
	public void setCommentNotGrateId(Integer commentNotGrateId) {
		CommentNotGrateId = commentNotGrateId;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public Integer getCommentNotGrateUid() {
		return CommentNotGrateUid;
	}
	public void setCommentNotGrateUid(Integer commentNotGrateUid) {
		CommentNotGrateUid = commentNotGrateUid;
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
