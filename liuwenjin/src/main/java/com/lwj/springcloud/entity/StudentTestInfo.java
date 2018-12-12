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
@Table(name = "studenttestinfotb")
@GenericGenerator(name = "id", strategy = "increment")
@Data
public class StudentTestInfo {
	@Id
	@GeneratedValue	
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动增长主键'")
	private Integer id;
	@Column(columnDefinition="comment '备注:测试试卷id'")
	private Integer testId;
	@Column(columnDefinition="comment '备注:学生id'")
	private Integer studentId;
	@Column(columnDefinition="comment '备注:测试次数'")
	private Integer testNum;
	@Column(columnDefinition="comment '备注:测试剩余时间'")
	private Date spareTime;
}
