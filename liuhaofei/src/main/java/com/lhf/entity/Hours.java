package com.lhf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="hours")
public class Hours {
	@Id
	@GeneratedValue
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:课时编号'  ")
	private int hour_id;
	@Column(columnDefinition="varchar(50) comment '备注:课时所属课程 ' ")
	private String hour_course;
	@Column(columnDefinition="int comment '备注:课时父id ' ")
	private int hour_parent_id;
	@Column(columnDefinition="varchar(50) comment '课时名称 ' ")
	private String hour_name;
	@Transient
	private String hour_xxx;
	public Hours() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hours(int hour_id, String hour_course, int hour_parent_id, String hour_name, String hour_xxx) {
		super();
		this.hour_id = hour_id;
		this.hour_course = hour_course;
		this.hour_parent_id = hour_parent_id;
		this.hour_name = hour_name;
		this.hour_xxx = hour_xxx;
	}
	public int getHour_id() {
		return hour_id;
	}
	public void setHour_id(int hour_id) {
		this.hour_id = hour_id;
	}
	public String getHour_course() {
		return hour_course;
	}
	public void setHour_course(String hour_course) {
		this.hour_course = hour_course;
	}
	public int getHour_parent_id() {
		return hour_parent_id;
	}
	public void setHour_parent_id(int hour_parent_id) {
		this.hour_parent_id = hour_parent_id;
	}
	public String getHour_name() {
		return hour_name;
	}
	public void setHour_name(String hour_name) {
		this.hour_name = hour_name;
	}
	@Override
	public String toString() {
		return "Hours [hour_id=" + hour_id + ", hour_course=" + hour_course + ", hour_parent_id=" + hour_parent_id
				+ ", hour_name=" + hour_name + ", hour_xxx=" + hour_xxx + "]";
	}
	

}
