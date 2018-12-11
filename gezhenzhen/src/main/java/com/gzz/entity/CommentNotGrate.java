package com.gzz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="commentnotgratetb")
public class CommentNotGrate {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：评论点踩表自动增长主键'")
	@JsonProperty(value ="id")
	private Integer CommentNotGrateId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：评论表id外键'")
	private Integer CommentNotGrateCommentId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer CommentNotGrateUid;
	@Transient
	private Integer Exet1;
	@Transient
	private String Exet2;


}
