package com.gzz.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

//贴吧表
@Entity
@Table(name="postbartb")
public class Postbar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '贴吧ID'")
	@JsonProperty(value ="id")
	private Integer postbarId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：用户的id外键'")
	private Integer uId;
	@JsonIgnore 
	 @ManyToMany          										
	 @JoinTable(name="postbar_category",                          
	 joinColumns={@JoinColumn(name="postbar_category_postbar_id")},  
	 inverseJoinColumns={@JoinColumn(name="postbar_category_postbar_category_id")})   
	 @NotFound(action = NotFoundAction.IGNORE)     
	 private Set<PostbarCategory>  postbarCategorySet = new HashSet<PostbarCategory>();
	@Column(length=50)
	private String postbarTitle;
	@Column(length=200)
	private String postbarContent;
	@JsonFormat(locale="zh",timezone="GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
	private Date postbarCreateTime;
	@Column(columnDefinition="TIMESTAMP",nullable=false,insertable=false,updatable=false)
	private Timestamp poostbarLastTime;
	@OneToMany(mappedBy="postbar",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<PostbarGood> postbarGood=new ArrayList<>();
	@OneToMany(mappedBy="postbar",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<PostbarNotGood> postbarNotGood=new ArrayList<>();
	@OneToMany(mappedBy="postbar",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<PostbarReport> postbarRepot=new ArrayList<>();
	@OneToMany(mappedBy="postbar",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<PostbarReply> postbarReply=new ArrayList<>();
	public Integer getPostbarId() {
		return postbarId;
	}
	public void setPostbarId(Integer postbarId) {
		this.postbarId = postbarId;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public Set<PostbarCategory> getPostbarCategorySet() {
		return postbarCategorySet;
	}
	public void setPostbarCategorySet(Set<PostbarCategory> postbarCategorySet) {
		this.postbarCategorySet = postbarCategorySet;
	}
	public String getPostbarTitle() {
		return postbarTitle;
	}
	public void setPostbarTitle(String postbarTitle) {
		this.postbarTitle = postbarTitle;
	}
	public String getPostbarContent() {
		return postbarContent;
	}
	public void setPostbarContent(String postbarContent) {
		this.postbarContent = postbarContent;
	}
	public Date getPostbarCreatetime() {
		return postbarCreateTime;
	}
	public void setPostbarCreateTime(Date postbarCreateTime) {
		this.postbarCreateTime = postbarCreateTime;
	}
	public Timestamp getPoostbarLastTime() {
		return poostbarLastTime;
	}
	public void setPoostbarLastTime(Timestamp poostbarLastTime) {
		this.poostbarLastTime = poostbarLastTime;
	}
	public List<PostbarGood> getPostbarGood() {
		return postbarGood;
	}
	public void setPostbarGood(List<PostbarGood> postbarGood) {
		this.postbarGood = postbarGood;
	}
	public List<PostbarNotGood> getPostbarNotGood() {
		return postbarNotGood;
	}
	public void setPostbarNotGood(List<PostbarNotGood> postbarNotGood) {
		this.postbarNotGood = postbarNotGood;
	}
	public List<PostbarReport> getPostbarRepot() {
		return postbarRepot;
	}
	public void setPostbarRepot(List<PostbarReport> postbarRepot) {
		this.postbarRepot = postbarRepot;
	}
	public List<PostbarReply> getPostbarReply() {
		return postbarReply;
	}
	public void setPostbarReply(List<PostbarReply> postbarReply) {
		this.postbarReply = postbarReply;
	}
	
}
