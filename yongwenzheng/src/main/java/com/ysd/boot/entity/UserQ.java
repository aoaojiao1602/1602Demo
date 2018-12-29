package com.ysd.boot.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UserQ {
	
	private String usersName;
	private Boolean usersIsLockout;
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME,pattern="yyyy-MM-dd HH:mm:ss")
	private Date startUsersCreateTime;
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME,pattern="yyyy-MM-dd HH:mm:ss")
	private Date endUsersCreateTime;
	public String getUsersName() {
		return usersName;
	}
	public void setUserName(String usersName) {
		this.usersName = usersName;
	}
	public Boolean getUsersIsLockout() {
		return usersIsLockout;
	}
	public void setUsersIsLockout(Boolean usersIsLockout) {
		this.usersIsLockout = usersIsLockout;
	}
	public Date getStartUsersCreateTime() {
		return startUsersCreateTime;
	}
	public void setStartUsersCreateTime(Date startUsersCreateTime) {
		this.startUsersCreateTime = startUsersCreateTime;
	}
	public Date getEndUsersCreateTime() {
		return endUsersCreateTime;
	}
	public void setEndUsersCreateTime(Date endUsersCreateTime) {
		this.endUsersCreateTime = endUsersCreateTime;
	}
	
}
