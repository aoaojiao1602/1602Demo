package com.lhf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="courseware")
public class Courseware {
	@Id
	@GeneratedValue
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:课件编号'  ")
	private int cwId;
	@Column(columnDefinition="varchar(50) comment '备注:课件所属课时 ' ")
	private String cwHour;
	@Column(columnDefinition="varchar(50) comment '备注:课件类型 ' ")
	private String cwCategory;
	@Column(columnDefinition="varchar(50) comment '备注:课件名称 ' ")
	private String cwName;
	@Column(columnDefinition="varchar(50) comment '备注:课件资源URL'")
	private String cwUrl;
	public Courseware() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Courseware(int cwId, String cwHour, String cwCategory, String cwName, String cwUrl) {
		super();
		this.cwId = cwId;
		this.cwHour = cwHour;
		this.cwCategory = cwCategory;
		this.cwName = cwName;
		this.cwUrl = cwUrl;
	}
	public int getCwId() {
		return cwId;
	}
	public void setCwId(int cwId) {
		this.cwId = cwId;
	}
	public String getCwHour() {
		return cwHour;
	}
	public void setCwHour(String cwHour) {
		this.cwHour = cwHour;
	}
	public String getCwCategory() {
		return cwCategory;
	}
	public void setCwCategory(String cwCategory) {
		this.cwCategory = cwCategory;
	}
	public String getCwName() {
		return cwName;
	}
	public void setCwName(String cwName) {
		this.cwName = cwName;
	}
	public String getCwUrl() {
		return cwUrl;
	}
	public void setCwUrl(String cwUrl) {
		this.cwUrl = cwUrl;
	}
	@Override
	public String toString() {
		return "Courseware [cwId=" + cwId + ", cwHour=" + cwHour + ", cwCategory=" + cwCategory + ", cwName=" + cwName
				+ ", cwUrl=" + cwUrl + "]";
	}
	

}
