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
@Table(name="replyreporttb")
public class ReplyReport {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：回复举报自动增长主键'")
	@JsonProperty(value ="id")
	private Integer ReplyReportId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：回复表的id外键'")
	private Integer ReplyReportReplyId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer  ReplyReportUid;
	@Column(length=100)
	private String  ReplyReportContent;
	@Column(columnDefinition="TIMESTAMP",nullable=false,insertable=false,updatable=false)
	private Timestamp ReplyReportTime;
	@Transient
	private Integer Exet1;
	@Transient
	private String Exet2;


}
