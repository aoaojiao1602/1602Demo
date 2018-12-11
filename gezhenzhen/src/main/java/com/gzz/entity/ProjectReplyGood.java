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
@Table(name="projectreplygoodtb")
public class ProjectReplyGood {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：回复点赞自动增长主键'")
	@JsonProperty(value ="id")
	private Integer ProjectReplyGoodId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：回复表的id外键'")
	private Integer ProjectReplyGoodProjectReplyId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer ProjectReplyGoodUid;
	@Transient
	private Integer Exet1;
	@Transient
	private String Exet2;

	

}
