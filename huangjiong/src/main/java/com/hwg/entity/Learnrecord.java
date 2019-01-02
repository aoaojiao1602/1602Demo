package com.hwg.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @Description 学习记录实体
 * @author HJiong
 * @time 2018年12月13日 下午7:11:21
 */
@Entity
@Table(name = "learnrecordtb")
public class Learnrecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:学习记录表主键'")
	private Integer lrId;
	@Column(columnDefinition = "varchar(20) NOT NULL comment '备注:课程编号'")
	private String learnCourseId;
	@Column(columnDefinition = "varchar(200) NOT NULL comment '备注:学习进度'")
	private String learnCourseRecord;
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:视频进度记忆点'")
	private Integer learnCourseTime;
	@Column(columnDefinition = "varchar(200) NULL comment '备注:学习记录备注'")
	private String learnRemark;
	@Column(columnDefinition = "varchar(20) NOT NULL comment '备注:学生编号'")
	private String learnStuId;
	@Column(columnDefinition = "Timestamp DEFAULT CURRENT_TIMESTAMP comment '备注:最近修改时间'")
	private Timestamp updateTime;
	@Transient
	private Integer filed1;
	@Transient
	private String filed2;
	public Integer getLrId() {
		return lrId;
	}
	public void setLrId(Integer lrId) {
		this.lrId = lrId;
	}
	public String getLearnCourseId() {
		return learnCourseId;
	}
	public void setLearnCourseId(String learnCourseId) {
		this.learnCourseId = learnCourseId;
	}
	public String getLearnCourseRecord() {
		return learnCourseRecord;
	}
	public void setLearnCourseRecord(String learnCourseRecord) {
		this.learnCourseRecord = learnCourseRecord;
	}
	public Integer getLearnCourseTime() {
		return learnCourseTime;
	}
	public void setLearnCourseTime(Integer learnCourseTime) {
		this.learnCourseTime = learnCourseTime;
	}
	public String getLearnRemark() {
		return learnRemark;
	}
	public void setLearnRemark(String learnRemark) {
		this.learnRemark = learnRemark;
	}
	public String getLearnStuId() {
		return learnStuId;
	}
	public void setLearnStuId(String learnStuId) {
		this.learnStuId = learnStuId;
	}
	public Integer getFiled1() {
		return filed1;
	}
	public void setFiled1(Integer filed1) {
		this.filed1 = filed1;
	}
	public String getFiled2() {
		return filed2;
	}
	public void setFiled2(String filed2) {
		this.filed2 = filed2;
	}
	@Override
	public String toString() {
		return "Learnrecord [lrId=" + lrId + ", learnCourseId=" + learnCourseId + ", learnCourseRecord="
				+ learnCourseRecord + ", learnCourseTime=" + learnCourseTime + ", learnRemark=" + learnRemark
				+ ", learnStuId=" + learnStuId + ", filed1=" + filed1 + ", filed2=" + filed2 + "]";
	}
	
	
}
