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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="commentreporttb")
public class CommentReport {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：评论举报表自动增长主键'")
	@JsonProperty(value ="id")
	private Integer CommentReportId;
	@JsonIgnore
	@ManyToOne(targetEntity = ProjectReply.class)
	@JoinColumn(name="CommentReportCommentId")
	private Comment comment;
	/*@Column(columnDefinition="int unsigned NOT NULL comment '备注：评论表id外键'")
	private Integer CommentReportCommentId;*/
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer CommentReportUid;
	@Column(length=100)
	private String CommentReportContent;
	@Column(columnDefinition="TIMESTAMP",nullable=false,insertable=false,updatable=false)
	private Timestamp CommentReportCreateTime;
	@Transient
	private Integer Exet1;
	@Transient
	private String Exet2;
	public Integer getCommentReportId() {
		return CommentReportId;
	}
	public void setCommentReportId(Integer commentReportId) {
		CommentReportId = commentReportId;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public Integer getCommentReportUid() {
		return CommentReportUid;
	}
	public void setCommentReportUid(Integer commentReportUid) {
		CommentReportUid = commentReportUid;
	}
	public String getCommentReportContent() {
		return CommentReportContent;
	}
	public void setCommentReportContent(String commentReportContent) {
		CommentReportContent = commentReportContent;
	}
	public Timestamp getCommentReportCreateTime() {
		return CommentReportCreateTime;
	}
	public void setCommentReportCreateTime(Timestamp commentReportCreateTime) {
		CommentReportCreateTime = commentReportCreateTime;
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
