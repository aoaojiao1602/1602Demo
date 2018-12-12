package com.lwj.springcloud.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
@Entity
@Table(name = "studentexaminfotb")
@GenericGenerator(name = "id", strategy = "increment")
@Data
public class StudentExamInfo {
	@Id
	@GeneratedValue	
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动增长主键'")
	private Integer id;
	@Column(columnDefinition="comment '备注:学生id'")
	private Integer studentId;
	@Column(columnDefinition="comment '备注:考试信息id'")
	private Integer exId;
	@Column(columnDefinition="comment '备注:分数'")
	private String examScore;
	@Column(columnDefinition="comment '备注:倒计时'")
	private Date time;
}
