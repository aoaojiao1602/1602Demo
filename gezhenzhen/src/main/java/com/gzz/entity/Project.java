package com.gzz.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="projecttb")
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：课程贴吧自动增长主键'")
	@JsonProperty(value ="id")
	private Integer projectId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer uId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：模块的id外键'")
	private Integer projectModuleid;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：课件的id外键'")
	private Integer clazzId;
	@Column(columnDefinition="int DEFAULT 0 comment '备注：是否关注'")
	private Integer projectState;
	@Column(length=50)
	private String projectTitle;
	@Column(length=200)
	private String projectContent;
	@JsonFormat(locale="zh",timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
	private Date projectCreatetime;
	@Column(columnDefinition="TIMESTAMP",nullable=false,insertable=false,updatable=false)
	private Timestamp projectLastTime;
	@Transient
	private Integer Exet1;
	@Transient
	private String Exet2;


}
