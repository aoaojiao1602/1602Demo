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
@Table(name = "userinfotb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfo {

	@Id
	@GeneratedValue
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:用户自动增长主键' ")
	private Integer u_uid;
	@Column(columnDefinition = "varchar(50) comment '备注:用户头像url'")
	private String ui_headportrait;
	@Column(columnDefinition = "Varchar(100) comment '备注:用户头像名'")
	private String ui_headportraitname;
	@Column(columnDefinition = "varchar(20) unique comment '备注:用户昵称'")
	private String ui_nickname;
	@Column(columnDefinition = "varchar(5) comment '备注:性别'")
	private String ui_sex;
	@Column(columnDefinition = "datetime comment '备注:出生年用'")
	private Date ui_birthday;
	@Column(columnDefinition = "varchar(11) unique comment '备注:手机号'")
	private String ui_phone;
	@Column(columnDefinition = "varchar(50) comment '备注:邮箱'")
	private String ui_email;
	@Column(columnDefinition = "varchar(8) comment '备注:用户真实姓名'")
	private String ui_truename;
	@Column(columnDefinition = "varchar(18) unique comment '备注:用户身份证'")
	private String ui_identitycard;
	@Column(columnDefinition = "varchar(50) comment '备注:用户身份类型'")
	private String Identity;
	@Column(columnDefinition = "varchar(50) comment '备注:用户行业'")
	private String industry;
	@Column(columnDefinition = "varchar(50) comment '备注:用户最高学历'")
	private String education;
	@Column(columnDefinition = "varchar(300) comment '备注:用户个人简介'")
	private String jianjie;
	@Column(columnDefinition = "varchar(20) comment '备注:用户院系'")
	private String yuanx;
	@Column(columnDefinition = "int comment '备注:用户id'")
	private Integer uid;
	@Transient
	private String userSpace = "";

	@Override
	public String toString() {
		return "UserInfo [u_uid=" + u_uid + ", ui_headportrait=" + ui_headportrait + ", ui_headportraitname="
				+ ui_headportraitname + ", ui_nickname=" + ui_nickname + ", ui_sex=" + ui_sex + ", ui_birthday="
				+ ui_birthday + ", ui_phone=" + ui_phone + ", ui_email=" + ui_email + ", ui_truename=" + ui_truename
				+ ", ui_identitycard=" + ui_identitycard + ", Identity=" + Identity + ", industry=" + industry
				+ ", education=" + education + ", jianjie=" + jianjie + ", yuanx=" + yuanx + ", uid=" + uid
				+ ", userSpace=" + userSpace + "]";
	}

}
