package com.lhf.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="courses")
public class Courses {
	@Id
	@GeneratedValue
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:课程编号'")
	private int Course_id;
	@Column(columnDefinition="comment '备注:课程类别'")
	private String Course_category;
	@Column(columnDefinition="comment '备注:课程名称'")
	private String Course_name;
	@Column(columnDefinition="comment '备注:课程说明'")
	private String Course_remark;
	@Column(columnDefinition="comment '备注:课程创建者'")
	private String Course_creator;
	@Column(columnDefinition="comment '备注:是否发布'")
	private String Course_state;
	@Column(columnDefinition="comment '备注:创建时间'")
	private Date Course_create_time;
	@Column(columnDefinition="comment '备注:编辑时间'")
	private Date Course_editor_time;
	public Courses() {
		super();
	}
	public Courses(int course_id, String course_category, String course_name, String course_remark,
			String course_creator, String course_state, Date course_create_time, Date course_editor_time) {
		super();
		Course_id = course_id;
		Course_category = course_category;
		Course_name = course_name;
		Course_remark = course_remark;
		Course_creator = course_creator;
		Course_state = course_state;
		Course_create_time = course_create_time;
		Course_editor_time = course_editor_time;
	}
	public int getCourse_id() {
		return Course_id;
	}
	public void setCourse_id(int course_id) {
		Course_id = course_id;
	}
	public String getCourse_category() {
		return Course_category;
	}
	public void setCourse_category(String course_category) {
		Course_category = course_category;
	}
	public String getCourse_name() {
		return Course_name;
	}
	public void setCourse_name(String course_name) {
		Course_name = course_name;
	}
	public String getCourse_remark() {
		return Course_remark;
	}
	public void setCourse_remark(String course_remark) {
		Course_remark = course_remark;
	}
	public String getCourse_creator() {
		return Course_creator;
	}
	public void setCourse_creator(String course_creator) {
		Course_creator = course_creator;
	}
	public String getCourse_state() {
		return Course_state;
	}
	public void setCourse_state(String course_state) {
		Course_state = course_state;
	}
	public Date getCourse_create_time() {
		return Course_create_time;
	}
	public void setCourse_create_time(Date course_create_time) {
		Course_create_time = course_create_time;
	}
	public Date getCourse_editor_time() {
		return Course_editor_time;
	}
	public void setCourse_editor_time(Date course_editor_time) {
		Course_editor_time = course_editor_time;
	}
	@Override
	public String toString() {
		return "Courses [Course_id=" + Course_id + ", Course_category=" + Course_category + ", Course_name="
				+ Course_name + ", Course_remark=" + Course_remark + ", Course_creator=" + Course_creator
				+ ", Course_state=" + Course_state + ", Course_create_time=" + Course_create_time
				+ ", Course_editor_time=" + Course_editor_time + "]";
	}
	

}
