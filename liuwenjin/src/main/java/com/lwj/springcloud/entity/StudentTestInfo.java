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

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
@Entity
@Table(name = "studentTestinfotb")
@GenericGenerator(name = "id", strategy = "increment")
@Data
//学生测试信息
public class StudentTestInfo {
	@Id
	@GeneratedValue	
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动增长主键'")
	private Integer id;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="testinfoId",unique = true)
	private TestInfo testInfo;
	private Integer studentId;
	@Column(columnDefinition="int comment '备注:测试次数'")
	private Integer testNum;
	@Column(columnDefinition="int comment '备注:测试剩余时间'")
	private Integer spareTime;
}
