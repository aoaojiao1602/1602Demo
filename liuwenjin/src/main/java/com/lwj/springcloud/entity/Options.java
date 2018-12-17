package com.lwj.springcloud.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "optiontb")
@GenericGenerator(name = "optionId", strategy = "increment")
@Data
//选择题表
public class Options {
	@Id
	@GeneratedValue	
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动增长主键'")
	private Integer optionId;
	@Column(columnDefinition="varchar(100) comment '备注:题目'")
	private String topic;
	@Column(columnDefinition="varchar(20) comment '备注:A选项'")
	private String optionA;
	@Column(columnDefinition="varchar(20) comment '备注:B选项'")
	private String optionB;
	@Column(columnDefinition="varchar(20) comment '备注:C选项'")
	private String optionC;
	@Column(columnDefinition="varchar(20) comment '备注:D选项'")
	private String optionD;
	@Column(columnDefinition="varchar(10) comment '备注:答案'")
	private String answer;
	@Column(columnDefinition="int comment '备注:分数'")
	private Integer score;
	@JsonIgnore
	@OneToOne(optional = false, mappedBy = "options", fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.DELETE}) 
	@JoinColumn(name = "option_id",unique = true)
	private Question question;
}
