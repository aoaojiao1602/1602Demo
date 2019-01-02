package com.lhf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pic")
public class Pic {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:图片编号'  ")
	private int picId;
	@Column(columnDefinition="varchar(50) comment '备注:所属课程 ' ")
	private String picCourse;
	@Column(columnDefinition="varchar(80) comment '备注:图片资源URL' ")
	private String picUrl;
	public Pic() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pic(int picId, String picCourse, String picUrl) {
		super();
		this.picId = picId;
		this.picCourse = picCourse;
		this.picUrl = picUrl;
	}
	public int getPicId() {
		return picId;
	}
	public void setPicId(int picId) {
		this.picId = picId;
	}
	public String getPicCourse() {
		return picCourse;
	}
	public void setPicCourse(String picCourse) {
		this.picCourse = picCourse;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	@Override
	public String toString() {
		return "Pic [picId=" + picId + ", picCourse=" + picCourse + ", picUrl=" + picUrl + "]";
	}
	
	

}
