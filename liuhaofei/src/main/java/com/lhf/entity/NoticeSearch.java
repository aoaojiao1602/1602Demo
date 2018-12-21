package com.lhf.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NoticeSearch {
	private String noticeCourse;
	private String noticeName;
	private String noticeContent;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private String startCreateTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private String endCreateTime;
	public NoticeSearch(String noticeCourse, String noticeName, String noticeContent, String startCreateTime,
			String endCreateTime) {
		super();
		this.noticeCourse = noticeCourse;
		this.noticeName = noticeName;
		this.noticeContent = noticeContent;
		this.startCreateTime = startCreateTime;
		this.endCreateTime = endCreateTime;
	}
	public NoticeSearch() {
		super();
	}
	public String getNoticeCourse() {
		return noticeCourse;
	}
	public void setNoticeCourse(String noticeCourse) {
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
	public String getStartCreateTime() {
		return startCreateTime;
	}
	public void setStartCreateTime(String startCreateTime) {
		this.startCreateTime = startCreateTime;
	}
	public String getEndCreateTime() {
		return endCreateTime;
	}
	public void setEndCreateTime(String endCreateTime) {
		this.endCreateTime = endCreateTime;
	}
	@Override
	public String toString() {
		return "NoticeSearch [noticeCourse=" + noticeCourse + ", noticeName=" + noticeName + ", noticeContent="
				+ noticeContent + ", startCreateTime=" + startCreateTime + ", endCreateTime=" + endCreateTime + "]";
	}
	
	
}
