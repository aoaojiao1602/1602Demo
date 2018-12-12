package com.lwj.springcloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "judgetb")
@GenericGenerator(name = "judgeId", strategy = "increment")
@Data
public class Judges {
	@Id
	@GeneratedValue	
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动增长主键'")
	private Integer judgeId;
	@Column(columnDefinition="comment '备注:题目'")
	private String topic;
	@Column(columnDefinition="comment '备注:答案'")
	private String answer;
	@Column(columnDefinition="comment '备注:分数'")
	private Integer score;
}
