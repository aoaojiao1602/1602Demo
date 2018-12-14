package com.hwg.entity;

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
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:学生编号'")
	private Integer learnStuId;
	@Transient
	private Integer filed1;
	@Transient
	private String filed2;
}
