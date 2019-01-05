package com.hwg.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description 报名记录
 * @author HJiong
 * @time 2019年1月3日 下午11:47:32
 */
@Entity
@Table(name="baomingtb")
public class Baoming {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:主键'")
	private Integer bid;
	@Column(columnDefinition = "int(11) NOT NULL COMMENT '课程id'")
	private Integer courseId;
	@Column(columnDefinition = "int(11) NOT NULL COMMENT '学生id'")
	private Integer stuId;
	@Column(columnDefinition = "Timestamp DEFAULT CURRENT_TIMESTAMP comment '备注:创建时间'")
	private Timestamp crateTime;
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	
	
	
	

}
