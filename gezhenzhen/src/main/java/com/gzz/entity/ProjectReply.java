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
@Table(name="projectreplytb")
public class ProjectReply {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：贴吧回复自动增长主键'")
	@JsonProperty(value ="id")
	private Integer projectReplyId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer projectReplyUid;
	@Column(length=200)
	private String projectReplyContent;
	@Column(columnDefinition="TIMESTAMP",nullable=false,insertable=false,updatable=false)
	private Timestamp projectReplyCreateTime;
	/*@Column(columnDefinition="int unsigned NOT NULL comment '备注：贴吧的id外键'")
	private Integer projectReplyProjectId;*/
	@JsonIgnore
	@ManyToOne(targetEntity = Project.class)
	@JoinColumn(name="projectReplyProjectId")
	private Project project;
	@OneToMany(mappedBy="projectReply",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<ProjectReplyGood> projectReplyGood=new ArrayList<>();
	@OneToMany(mappedBy="projectReply",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<ProjectReplyNotGood> projectReplyNotGood=new ArrayList<>();
	@OneToMany(mappedBy="projectReply",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<ReplyReport> replyReport =new ArrayList<>();
	@Transient
	private Integer Exet1;
	@Transient
	private String Exet2;


}
