package com.lhf.entity;



import java.util.Date;

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
	private int CourseId;
	@Column(columnDefinition="varchar(50) comment '备注:课程类别'")
	private String CourseCategory;
	@Column(columnDefinition="varchar(50) comment '备注:课程名称'")
	private String CourseName;
	@Column(columnDefinition="varchar(100) comment '备注:课程说明'")
	private String CourseRemark;
	@Column(columnDefinition="varchar(50) comment '备注:课程创建者'")
	private String CourseCreator;
	@Column(columnDefinition="varchar(10) comment '备注:是否发布'")
	private String CourseState;
	@Column(columnDefinition="timestamp comment'备注:创建时间'")
	private Date CourseCreateTime;
	@Column(columnDefinition="timestamp comment'备注:编辑时间'")
	private Date CourseEditorTime;
	public Courses() {
		super();
	}
	public Courses(int courseId, String courseCategory, String courseName, String courseRemark, String courseCreator,
			String courseState, Date courseCreateTime, Date courseEditorTime) {
		super();
		CourseId = courseId;
		CourseCategory = courseCategory;
		CourseName = courseName;
		CourseRemark = courseRemark;
		CourseCreator = courseCreator;
		CourseState = courseState;
		CourseCreateTime = courseCreateTime;
		CourseEditorTime = courseEditorTime;
	}
	public int getCourseId() {
		return CourseId;
	}
	public void setCourseId(int courseId) {
		CourseId = courseId;
	}
	public String getCourseCategory() {
		return CourseCategory;
	}
	public void setCourseCategory(String courseCategory) {
		CourseCategory = courseCategory;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public String getCourseRemark() {
		return CourseRemark;
	}
	public void setCourseRemark(String courseRemark) {
		CourseRemark = courseRemark;
	}
	public String getCourseCreator() {
		return CourseCreator;
	}
	public void setCourseCreator(String courseCreator) {
		CourseCreator = courseCreator;
	}
	public String getCourseState() {
		return CourseState;
	}
	public void setCourseState(String courseState) {
		CourseState = courseState;
	}
	public Date getCourseCreateTime() {
		return CourseCreateTime;
	}
	public void setCourseCreateTime(Date courseCreateTime) {
		CourseCreateTime = courseCreateTime;
	}
	public Date getCourseEditorTime() {
		return CourseEditorTime;
	}
	public void setCourseEditorTime(Date courseEditorTime) {
		CourseEditorTime = courseEditorTime;
	}
	@Override
	public String toString() {
		return "Courses [CourseId=" + CourseId + ", CourseCategory=" + CourseCategory + ", CourseName=" + CourseName
				+ ", CourseRemark=" + CourseRemark + ", CourseCreator=" + CourseCreator + ", CourseState=" + CourseState
				+ ", CourseCreateTime=" + CourseCreateTime + ", CourseEditorTime=" + CourseEditorTime + "]";
	}
	
	

}
