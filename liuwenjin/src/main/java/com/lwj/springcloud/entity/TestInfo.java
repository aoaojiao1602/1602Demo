package com.lwj.springcloud.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Table(name = "testinfotb")
@GenericGenerator(name = "testId", strategy = "increment")
@Data
//测试信息表
public class TestInfo {
	@Id
	@GeneratedValue	
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动增长主键'")
	private Integer testId;
	@Column(columnDefinition="int comment '备注:剩余时间'")
	private Integer spareTime;
	@Column(columnDefinition="varchar(100) comment '备注:测试试卷名'")
	private String testName;
	@Column(columnDefinition="int comment '备注:测试次数'")
	private Integer testNum;
	@Column(columnDefinition="int comment '备注:测试建立时间'")
	private Integer createTime;
	@Column(columnDefinition="int comment '备注:章节id'")
	private Integer sectionId;
	@Column(columnDefinition="int comment '备注:选择题数量'")
	private Integer optionNum;
	@Column(columnDefinition="int comment '备注:分数'")
	private Integer testScore;
	
	@JsonIgnore
	@OneToOne(optional = false, mappedBy = "testInfo", fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.SAVE_UPDATE }) 
	@JoinColumn(name="testinfoId",unique = true)
	private StudentTestInfo studentTestInfo ;
}
