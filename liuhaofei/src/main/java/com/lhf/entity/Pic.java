package com.lhf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pic")
public class Pic {
	@Id
	@GeneratedValue
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:图片编号'  ")
	private int pic_id;
	@Column(columnDefinition="comment '备注:所属课程 ' ")
	private String pic_course;
	@Column(columnDefinition="comment '备注:图片资源URL' ")
	private String pic_URL;
	public Pic() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pic(int pic_id, String pic_course, String pic_URL) {
		super();
		this.pic_id = pic_id;
		this.pic_course = pic_course;
		this.pic_URL = pic_URL;
	}
	public int getPic_id() {
		return pic_id;
	}
	public void setPic_id(int pic_id) {
		this.pic_id = pic_id;
	}
	public String getPic_course() {
		return pic_course;
	}
	public void setPic_course(String pic_course) {
		this.pic_course = pic_course;
	}
	public String getPic_URL() {
		return pic_URL;
	}
	public void setPic_URL(String pic_URL) {
		this.pic_URL = pic_URL;
	}
	@Override
	public String toString() {
		return "Pic [pic_id=" + pic_id + ", pic_course=" + pic_course + ", pic_URL=" + pic_URL + "]";
	}

}
