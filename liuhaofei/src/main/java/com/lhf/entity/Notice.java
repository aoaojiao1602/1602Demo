package com.lhf.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="notice")
public class Notice {
	@Id
	@GeneratedValue
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:公告编号'  ")
	private int notice_id;
	@Column(columnDefinition="comment '备注:公告所属课程 ' ")
	private String notice_course;
	@Column(columnDefinition="comment '备注:公告名称 ' ")
	private String notice_name;
	@Column(columnDefinition="comment '备注:公告内容 ' ")
	private String notice_content;
	@Column(columnDefinition="comment '备注:发布时间 ' ")
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date notice_time;
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notice(int notice_id, String notice_course, String notice_name, String notice_content, Date notice_time) {
		super();
		this.notice_id = notice_id;
		this.notice_course = notice_course;
		this.notice_name = notice_name;
		this.notice_content = notice_content;
		this.notice_time = notice_time;
	}
	public int getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(int notice_id) {
		this.notice_id = notice_id;
	}
	public String getNotice_course() {
		return notice_course;
	}
	public void setNotice_course(String notice_course) {
		this.notice_course = notice_course;
	}
	public String getNotice_name() {
		return notice_name;
	}
	public void setNotice_name(String notice_name) {
		this.notice_name = notice_name;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public Date getNotice_time() {
		return notice_time;
	}
	public void setNotice_time(Date notice_time) {
		this.notice_time = notice_time;
	}
	@Override
	public String toString() {
		return "Notice [notice_id=" + notice_id + ", notice_course=" + notice_course + ", notice_name=" + notice_name
				+ ", notice_content=" + notice_content + ", notice_time=" + notice_time + "]";
	}

}
