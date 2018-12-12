package com.lwj.springcloud.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "questiontb")
@GenericGenerator(name = "qId", strategy = "increment")
@Data
public class Question {
	@Id
	@GeneratedValue	
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动增长主键'")
	private Integer qId;
	@Column(columnDefinition="comment '备注:教师id'")
	private Integer teacherId;
	@Column(columnDefinition="comment '备注:课程id'")
	private Integer courseId;
	@Column(columnDefinition="comment '备注:章节id'")
	private Integer sectionId;
	@Column(columnDefinition="TIMESTAMP",nullable=false,updatable=false,insertable=false)
	private Timestamp createTime;
	@Column(columnDefinition="comment '备注:选择题id'")
	private Integer optionId;
	@Column(columnDefinition="comment '备注:判断题id'")
	private Integer judgeId;
	@Column(columnDefinition="comment '备注:填空题id'")
	private Integer fillblankId;
	
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER) // 指定多对多关系 //默认懒加载,只有调用getter方法时才加载数据
	@Cascade(value = { CascadeType.SAVE_UPDATE }) // 设置级联关系
	@JoinTable(name = "examquestiontb", // 指定第三张中间表名称
			joinColumns = { @JoinColumn(name = "examquestiontb_question_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "examquestiontb_examinfo_id") })
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<Examinfo> eSet = new HashSet<Examinfo>();
}
