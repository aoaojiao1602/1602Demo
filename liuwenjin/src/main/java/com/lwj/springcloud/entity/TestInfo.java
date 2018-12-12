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
@Table(name = "testinfotb")
@GenericGenerator(name = "testId", strategy = "increment")
@Data
public class TestInfo {
	@Id
	@GeneratedValue	
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动增长主键'")
	private Integer testId;
	@Column(columnDefinition="comment '备注:剩余时间'")
	private Date spareTime;
	@Column(columnDefinition="comment '备注:测试试卷名'")
	private String testName;
	@Column(columnDefinition="comment '备注:测试次数'")
	private Integer testNum;
	@Column(columnDefinition="comment '备注:章节id'")
	private Integer sectionId;
	@Column(columnDefinition="comment '备注:选择题数量'")
	private Integer optionNum;
	@Column(columnDefinition="comment '备注:分数'")
	private Integer testScore;
}
