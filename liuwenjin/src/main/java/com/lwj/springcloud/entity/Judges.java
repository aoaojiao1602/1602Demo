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
@Table(name = "judgetb")
@GenericGenerator(name = "judgeId", strategy = "increment")
@Data
//判断题表
public class Judges {
	@Id
	@GeneratedValue	
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动增长主键'")
	private Integer judgeId;
	@Column(columnDefinition="varchar(100) comment '备注:题目'")
	private String topic;
	@Column(columnDefinition="tinyint(1)  comment '备注:答案'")
	private String answer;
	@Column(columnDefinition="int comment '备注:分数'")
	private Integer score;
	
	@JsonIgnore
	@JoinColumn(name="judges_id",unique = true)
	@OneToOne(optional = false, mappedBy = "judges", fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.DELETE}) 
	private Question question;
	
	public String getAnswer() {
		String str="";
		if (this.answer.equals("0")) {
			str="是"; 
		}else {
			str="否";
		}
		return str;
	}
}
