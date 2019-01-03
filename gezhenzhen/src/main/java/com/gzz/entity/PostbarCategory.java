package com.gzz.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

//贴吧类别表
@Entity
@Table(name="postbarCategorytb")
public class PostbarCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '贴吧类别ID'")
	@JsonProperty(value ="id")
	private Integer postbarCategoryId;
	@Column(length=50)
	private String postbarCategoryTitle;
	@JsonIgnore 
	 @ManyToMany           										
	 @JoinTable(name="postbar_category",                          
	 joinColumns={@JoinColumn(name="postbar_category_postbar_category_id")},  
	 inverseJoinColumns={@JoinColumn(name="postbar_category_postbar_id")})   
	 @NotFound(action = NotFoundAction.IGNORE)     
	 private Set<Postbar>  postbarSet = new HashSet<Postbar>();
	public Integer getPostbarCategoryId() {
		return postbarCategoryId;
	}
	public void setPostbarCategoryId(Integer postbarCategoryId) {
		this.postbarCategoryId = postbarCategoryId;
	}
	public String getPostbarCategoryTitle() {
		return postbarCategoryTitle;
	}
	public void setPostbarCategoryTitle(String postbarCategoryTitle) {
		this.postbarCategoryTitle = postbarCategoryTitle;
	}
	public Set<Postbar> getPostbarSet() {
		return postbarSet;
	}
	public void setPostbarSet(Set<Postbar> postbarSet) {
		this.postbarSet = postbarSet;
	}
	
}
