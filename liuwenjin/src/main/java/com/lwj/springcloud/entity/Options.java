package com.lwj.springcloud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "optiontb")
@GenericGenerator(name = "optionId", strategy = "increment")
@Data
public class Options {
	@Id
	@GeneratedValue	
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动增长主键'")
	private Integer optionId;
	@Column(columnDefinition="comment '备注:题目'")
	private String topic;
	@Column(columnDefinition="comment '备注:A选项'")
	private String optionA;
	@Column(columnDefinition="comment '备注:B选项'")
	private String optionB;
	@Column(columnDefinition="comment '备注:C选项'")
	private String optionC;
	@Column(columnDefinition="comment '备注:D选项'")
	private String optionD;
	@Column(columnDefinition="comment '备注:答案'")
	private String answer;
	@Column(columnDefinition="comment '备注:分数'")
	private Integer score;
}
