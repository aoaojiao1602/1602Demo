package com.xiaozuanfeng.springcloud.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="userinfotb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	
	@Id
	@GeneratedValue
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:用户自动增长主键' ")
	private Integer u_uid;
	@Column(columnDefinition = "int comment '备注:用户头像id'")
	private Integer ui_headportraitid;
	@Column(columnDefinition = "varchar(50) comment '备注:用户头像url'", nullable = false)
	private String ui_headportrait;
	@Column(columnDefinition = "Varchar(20) comment '备注:用户头像名'")
	private String ui_headportraitname;
	@Column(columnDefinition = "varchar(20) unique comment '备注:用户昵称'", nullable = false)
	private String ui_nickname;
	@Column(columnDefinition = "varchar(5) comment '备注:性别'")
	private String ui_sex;
	@Column(columnDefinition = "datetime comment '备注:出生年用'", nullable = false)
	private Date ui_birthday;
	@Column(columnDefinition = "varchar(11) unique comment '备注:手机号'", nullable = false)
	private String ui_phone;
	@Column(columnDefinition = "varchar(50) comment '备注:邮箱'")
	private String ui_email;
	@Column(columnDefinition = "varchar(8) comment '备注:用户真实姓名'")
	private String ui_truename;
	@Column(columnDefinition = "varchar(18) unique comment '备注:用户身份证'")
	private String ui_identitycard;
	@Transient
	private String userSpace = "";
	
	@Override
	public String toString() {
		return "UserInfo [u_uid=" + u_uid + ", ui_headportraitid=" + ui_headportraitid + ", ui_headportrait="
				+ ui_headportrait + ", ui_headportraitname=" + ui_headportraitname + ", ui_nickname=" + ui_nickname
				+ ", ui_sex=" + ui_sex + ", ui_birthday=" + ui_birthday + ", ui_phone=" + ui_phone + ", ui_email="
				+ ui_email + ", ui_truename=" + ui_truename + ", ui_identitycard=" + ui_identitycard + ", userSpace="
				+ userSpace + "]";
	}
	
	

}
