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
	private int cw_id;
	@Column(columnDefinition="comment '备注:课件所属课时 ' ")
	private String cw_hour;
	@Column(columnDefinition="comment '备注:课件类型 ' ")
	private String cw_category;
	@Column(columnDefinition="comment '备注:课件名称 ' ")
	private String cw_name;
	@Column(columnDefinition="comment '备注:课件资源URL'")
	private String cw_URL;
	public Courseware() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Courseware(int cw_id, String cw_hour, String cw_category, String cw_name, String cw_URL) {
		super();
		this.cw_id = cw_id;
		this.cw_hour = cw_hour;
		this.cw_category = cw_category;
		this.cw_name = cw_name;
		this.cw_URL = cw_URL;
	}
	public int getCw_id() {
		return cw_id;
	}
	public void setCw_id(int cw_id) {
		this.cw_id = cw_id;
	}
	public String getCw_hour() {
		return cw_hour;
	}
	public void setCw_hour(String cw_hour) {
		this.cw_hour = cw_hour;
	}
	public String getCw_category() {
		return cw_category;
	}
	public void setCw_category(String cw_category) {
		this.cw_category = cw_category;
	}
	public String getCw_name() {
		return cw_name;
	}
	public void setCw_name(String cw_name) {
		this.cw_name = cw_name;
	}
	public String getCw_URL() {
		return cw_URL;
	}
	public void setCw_URL(String cw_URL) {
		this.cw_URL = cw_URL;
	}
	@Override
	public String toString() {
		return "Courseware [cw_id=" + cw_id + ", cw_hour=" + cw_hour + ", cw_category=" + cw_category + ", cw_name="
				+ cw_name + ", cw_URL=" + cw_URL + "]";
	}

}
