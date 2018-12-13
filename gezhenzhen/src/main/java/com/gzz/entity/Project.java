package com.gzz.entity;

import java.sql.Date;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@JsonIgnore
	@ManyToOne(targetEntity = Project.class)
	@JoinColumn(name="projectModuleid")
	private Module module;
	/*@Column(columnDefinition="int unsigned NOT NULL comment '备注：模块的id外键'")
	private Integer projectModuleid;*/
	@Column(columnDefinition="int unsigned comment '备注：课件的id外键'")
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
	@OneToMany(mappedBy="project",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<ProjectReply> projectReply=new ArrayList<>();
	@OneToMany(mappedBy="project",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<ProjectCount> projectCount=new ArrayList<>();
	@OneToMany(mappedBy="project",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<ProjectNotCount> projectNotCountsCount=new ArrayList<>();
	@OneToMany(mappedBy="project",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<ProjectReport> projectReport =new ArrayList<>();
	@OneToMany(mappedBy="project",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Through> through =new ArrayList<>();
	@Transient
	private Integer Exet1;
	@Transient
	private String Exet2;
	
}
