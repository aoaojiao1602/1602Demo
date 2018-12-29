package com.ysd.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="coursetb")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {
	@Id//实体类的主键
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//自动增长列
 	@OrderBy	//数据加载顺序
 	@Column(columnDefinition="int unsigned NOT NULL comment '备注:课程推荐id'  ")
	private Integer courseId;
	@Column(columnDefinition="int comment '备注:课程id'  ")
	private Integer kechId;
	@Column(columnDefinition="int unsigned DEFAULT 0 comment '备注:权重'  ")
	private Integer courseWeigh;
	@Column(columnDefinition="int unsigned DEFAULT 0 comment '备注:课程推荐'")
	private Integer courseStatus;
	@Column(columnDefinition="varchar(100) comment '备注:备注'  ")
	private String navRemark;	
	@Column(columnDefinition="int comment '备注:导航id'")
	private Integer navigationId;	
	@Column(columnDefinition="int unsigned DEFAULT 0 comment '备注:位置id'")
	private Integer positionsId;
}
