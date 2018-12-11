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
@Table(name="projectreplytb")
public class ProjectReply {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：贴吧回复自动增长主键'")
	@JsonProperty(value ="id")
	private Integer projectReplyId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：贴吧的id外键'")
	private Integer projectReplyProjectId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer projectReplyUid;
	@Column(length=200,columnDefinition="comment '备注：回复的内容'")
	private String projectReplyContent;
	@Column(columnDefinition="TIMESTAMP",nullable=false,insertable=false,updatable=false)
	private Timestamp projectReplyCreateTime;
	@Transient
	private Integer Exet1;
	@Transient
	private String Exet2;


}
