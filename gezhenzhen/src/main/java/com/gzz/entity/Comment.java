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
	
	


}
