package com.lhf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="hours")
public class Hours {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int  NOT NULL comment '备注:课时编号'  ")
	private int hourId;
	@Column(columnDefinition="int comment '备注:课时所属课程 ' ")
	private int hourCourse;
	@Column(columnDefinition="int comment '备注:课时父id ' ")
	private int hourParentId;
	@Column(columnDefinition="varchar(50) comment '课时名称 ' ")
	private String hourName;
	@Transient
	private String hour_xxx;
	public Hours() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hours(int hourId, int hourCourse, int hourParentId, String hourName, String hour_xxx) {
		super();
		this.hourId = hourId;
		this.hourCourse = hourCourse;
		this.hourParentId = hourParentId;
		this.hourName = hourName;
		this.hour_xxx = hour_xxx;
	}
	public int getHourId() {
		return hourId;
	}
	public void setHourId(int hourId) {
		this.hourId = hourId;
	}
	public Integer getHourCourse() {
		return hourCourse;
	}
	public void setHourCourse(Integer hourCourse) {
		this.hourCourse = hourCourse;
	}
	public int getHourParentId() {
		return hourParentId;
	}
	public void setHourParentId(int hourParentId) {
		this.hourParentId = hourParentId;
	}
	public String getHourName() {
		return hourName;
	}
	public void setHourName(String hourName) {
		this.hourName = hourName;
	}
	public String getHour_xxx() {
		return hour_xxx;
	}
	public void setHour_xxx(String hour_xxx) {
		this.hour_xxx = hour_xxx;
	}
	@Override
	public String toString() {
		return "Hours [hourId=" + hourId + ", hourCourse=" + hourCourse + ", hourParentId=" + hourParentId
				+ ", hourName=" + hourName + ", hour_xxx=" + hour_xxx + "]";
	}
	
	

}
