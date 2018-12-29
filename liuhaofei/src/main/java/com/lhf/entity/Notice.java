package com.lhf.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="notice")
public class Notice {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int  NOT NULL comment '备注:公告编号'  ")
	private int noticeId;
	@Column(columnDefinition="int comment '备注:公告所属课程 ' ")
	private int noticeCourse;
	@Column(columnDefinition="varchar(50) comment '备注:公告名称 ' ")
	private String noticeName;
	@Column(columnDefinition="varchar(100) comment '备注:公告内容 ' ")
	private String noticeContent;
	@Column(columnDefinition="timestamp comment '备注:发布时间 ' ")
	private Date noticeTime;
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notice(int noticeId, int noticeCourse, String noticeName, String noticeContent, Date noticeTime) {
		super();
		this.noticeId = noticeId;
		this.noticeCourse = noticeCourse;
		this.noticeName = noticeName;
		this.noticeContent = noticeContent;
		this.noticeTime = noticeTime;
	}
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public Integer getNoticeCourse() {
		return noticeCourse;
	}
	public void setNoticeCourse(Integer noticeCourse) {
		this.noticeCourse = noticeCourse;
	}
	public String getNoticeName() {
		return noticeName;
	}
	public void setNoticeName(String noticeName) {
		this.noticeName = noticeName;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public Date getNoticeTime() {
		return noticeTime;
	}
	public void setNoticeTime(Date noticeTime) {
		this.noticeTime = noticeTime;
	}
	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", noticeCourse=" + noticeCourse + ", noticeName=" + noticeName
				+ ", noticeContent=" + noticeContent + ", noticeTime=" + noticeTime + "]";
	}
	
	

}
