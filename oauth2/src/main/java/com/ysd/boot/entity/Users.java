package com.ysd.boot.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@JsonInclude(value=Include.NON_DEFAULT)
@JsonInclude(value=Include.NON_NULL)
//@JsonInclude(value=Include.NON_EMPTY)//没有接收到的参数为空的不序列化
public class Users implements Serializable{
	

	private Integer usersId;
	
	
	private String usersName;
	
	
	private String usersPassword;
	
	
	private Integer usersIsLockout;
	
	 @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	 @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date usersCreateTime;
	
	 @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	 @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date usersUpdateTime;
	
	 @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	 @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date usersLastLoginTime;
	
	
	private String usersLastLoginIp;


	private Integer usersPassWrongCount;
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	 @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date usersLockOutTime;
	
	private String START_ARRAY;
	
	
	
	
}
