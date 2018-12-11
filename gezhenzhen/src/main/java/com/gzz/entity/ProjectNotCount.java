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
@Table(name="projectnotcounttb")
public class ProjectNotCount {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：贴吧点踩自动增长主键'")
	@JsonProperty(value = "id")
	private Integer projectNotCountId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：贴吧表的id外键'")
	private Integer projectNotCountProid;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer projectNotCountUid;
	@Transient
	private Integer Exet1;
	@Transient
	private String Exet2;


}
