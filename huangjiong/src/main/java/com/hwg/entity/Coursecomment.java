package com.hwg.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Description 课程评价实体
 * @author HJiong
 * @time 2018年12月13日 下午7:09:35
 */
@Entity
@Table(name = "coursecommenttb")
public class Coursecomment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:课程评论表主键'")
	private Integer commentId;
	@Column(columnDefinition = "varchar(500) NOT NULL comment '备注:评价内容'")
	private String commentContent;
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:课程编号'")
	private Integer commentCourseId;
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:课程类别编号'")
	private Integer commentCourseCategoryId;
	@Column(columnDefinition = "int unsigned DEFAULT(0) comment '备注:评论被赞次数 '")
	private Integer commentLike=0;
	@Column(columnDefinition = "int unsigned DEFAULT NULL comment '备注:评价星级'")
	private Integer commentStar;
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:学生编号'")
	private Integer commentStuId;
	@Column(columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '备注:评价时间'",nullable = false, insertable = false, updatable = false)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Timestamp commentTime;
	@Transient
	private Integer filed1;
	@Transient
	private String filed2;
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Integer getCommentCourseId() {
		return commentCourseId;
	}
	public void setCommentCourseId(Integer commentCourseId) {
		this.commentCourseId = commentCourseId;
	}
	public Integer getCommentLike() {
		return commentLike;
	}
	public void setCommentLike(Integer commentLike) {
		this.commentLike = commentLike;
	}
	public Integer getCommentStar() {
		return commentStar;
	}
	public void setCommentStar(Integer commentStar) {
		this.commentStar = commentStar;
	}
	public Integer getCommentStuId() {
		return commentStuId;
	}
	public void setCommentStuId(Integer commentStuId) {
		this.commentStuId = commentStuId;
	}
	public Timestamp getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}
	public Integer getFiled1() {
		return filed1;
	}
	public void setFiled1(Integer filed1) {
		this.filed1 = filed1;
	}
	public String getFiled2() {
		return filed2;
	}
	public void setFiled2(String filed2) {
		this.filed2 = filed2;
	}
	public Integer getCommentCourseCategoryId() {
		return commentCourseCategoryId;
	}
	public void setCommentCourseCategoryId(Integer commentCourseCategoryId) {
		this.commentCourseCategoryId = commentCourseCategoryId;
	}
	@Override
	public String toString() {
		return "Coursecomment [commentId=" + commentId + ", commentContent=" + commentContent + ", commentCourseId="
				+ commentCourseId + ", commentCourseCategoryId=" + commentCourseCategoryId + ", commentLike="
				+ commentLike + ", commentStar=" + commentStar + ", commentStuId=" + commentStuId + ", commentTime="
				+ commentTime + ", filed1=" + filed1 + ", filed2=" + filed2 + "]";
	}
	
	

}