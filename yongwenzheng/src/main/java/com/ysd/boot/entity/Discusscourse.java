package com.ysd.boot.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OrderBy;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="discusscoursetb")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Discusscourse {
	@Id	//实体类的主键
 	@GeneratedValue(strategy=GenerationType.IDENTITY)	//自动增长列
 	@OrderBy	//数据加载顺序
 	@Column(columnDefinition="int unsigned NOT NULL comment '备注:主题推荐id'  ")
	private Integer discusscourseId;	
 	@Column(columnDefinition="int comment '备注:课程id'  ")
	private Integer kechId;
	@Column(columnDefinition="int comment '备注:老师id'  ")
	private Integer teacherId;
	@Column(columnDefinition="int unsigned DEFAULT 0 comment '备注:主题推荐状态'  ")
	private Integer discussStatus;
	
	@Column(columnDefinition="int unsigned DEFAULT 0 comment '备注:权重'  ")
	private Integer discussWeigh;
	
	@Column(columnDefinition="varchar(100)  comment '备注:备注'  ")
	private String discussRemark;
	
	@Column(columnDefinition="int unsigned DEFAULT 0 comment '备注:位置id'")
	private Integer positionsId;
	
}
