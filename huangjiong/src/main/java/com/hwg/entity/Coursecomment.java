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
 * @Description 课程评价实体
 * @author HJiong
 * @time 2018年12月13日 下午7:09:35
 */
@Entity
@Table(name = "coursecommenttb")
public class Coursecomment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:课程评论表主键'")
	private Integer commentId;
	@Column(columnDefinition = "varchar(500) NOT NULL comment '备注:评价内容'")
	private String commentContent;
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:课程编号'")
	private Integer commentCourseId;
	@Column(columnDefinition = "int unsigned DEFAULT NULL comment '备注:评论被赞次数'")
	private Integer commentLike;
	@Column(columnDefinition = "int unsigned DEFAULT NULL comment '备注:评价星级'")
	private Integer commentStar;
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:学生编号'")
	private Integer commentStuId;
	@Column(columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '备注:评价时间'",nullable = false, insertable = false, updatable = false)
	private Timestamp commentTime;
	@Transient
	private Integer filed1;
	@Transient
	private String filed2;

}