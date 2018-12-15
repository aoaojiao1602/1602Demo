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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="commenttb")
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：评论表自动增长主键'")
	@JsonProperty(value ="id")
	private Integer commentId;
	@JsonIgnore
	@ManyToOne(targetEntity = ProjectReply.class)
	@JoinColumn(name="commentReplyId")
	private ProjectReply projectReply;
	/*@Column(columnDefinition="int unsigned NOT NULL comment '备注：回复表id外键'")
	private Integer commentReplyId;*/
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id'")
	private Integer commentUid;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：评论父id'")
	private Integer parentId;
	@Column(length=200)
	private String commentContent;
	@Column(columnDefinition="TIMESTAMP",nullable=false,insertable=false,updatable=false)
	private Timestamp commentCreatetime;
	@OneToMany(mappedBy="comment",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<CommentGrate> commentGrate=new ArrayList<>();
	@OneToMany(mappedBy="comment",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<CommentNotGrate> commentNotGrate =new ArrayList<>();
	@OneToMany(mappedBy="comment",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<CommentReport> commentReport=new ArrayList<>();
	@Transient
	private Integer Exet1;
	@Transient
	private String Exet2;
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public ProjectReply getProjectReply() {
		return projectReply;
	}
	public void setProjectReply(ProjectReply projectReply) {
		this.projectReply = projectReply;
	}
	public Integer getCommentUid() {
		return commentUid;
	}
	public void setCommentUid(Integer commentUid) {
		this.commentUid = commentUid;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Timestamp getCommentCreatetime() {
		return commentCreatetime;
	}
	public void setCommentCreatetime(Timestamp commentCreatetime) {
		this.commentCreatetime = commentCreatetime;
	}
	public List<CommentGrate> getCommentGrate() {
		return commentGrate;
	}
	public void setCommentGrate(List<CommentGrate> commentGrate) {
		this.commentGrate = commentGrate;
	}
	public List<CommentNotGrate> getCommentNotGrate() {
		return commentNotGrate;
	}
	public void setCommentNotGrate(List<CommentNotGrate> commentNotGrate) {
		this.commentNotGrate = commentNotGrate;
	}
	public List<CommentReport> getCommentReport() {
		return commentReport;
	}
	public void setCommentReport(List<CommentReport> commentReport) {
		this.commentReport = commentReport;
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
