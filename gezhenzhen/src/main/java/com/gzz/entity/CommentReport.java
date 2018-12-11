package com.gzz.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="commentreporttb")
public class CommentReport {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：评论举报表自动增长主键'")
	@JsonProperty(value ="id")
	private Integer CommentReportId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：评论表id外键'")
	private Integer CommentReportCommentId;
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


}
