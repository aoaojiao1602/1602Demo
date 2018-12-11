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
@Table(name="commenttb")
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：评论表自动增长主键'")
	@JsonProperty(value ="id")
	private Integer commentId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：回复表id外键'")
	private Integer commentReplyId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id'")
	private Integer commentUid;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：评论父id'")
	private Integer parentId;
	@Column(length=200)
	private String commentContent;
	@Column(columnDefinition="TIMESTAMP",nullable=false,insertable=false,updatable=false)
	private Timestamp commentCreatetime;
	@Transient
	private Integer Exet1;
	@Transient
	private String Exet2;
	
	


}
