package com.lwj.springcloud.entity;

import java.sql.Timestamp;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "questiontb")
@GenericGenerator(name = "qId", strategy = "increment")
@Data
//题库表
public class Question {
	@Id
	@GeneratedValue	
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动增长主键'")
	private Integer qId;
	@Column(columnDefinition="int NOT NULL comment '备注:教师id'")
	private Integer teacherId;
	@Column(columnDefinition="int NOT NULL comment '备注:课程id'")
	private Integer courseId;
	@Column(columnDefinition="int NOT NULL comment '备注:章节id'")
	private Integer sectionId;
	@Column(columnDefinition="TIMESTAMP",nullable=false,updatable=false,insertable=false)
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date createTime;
	@ManyToOne(optional = false,targetEntity = Options.class)
	@JoinColumn(name="option_id")
	private Options optionId;
	@ManyToOne(optional = false,targetEntity = Judges.class)
	@JoinColumn(name="judges_id")
	private Judges judgeId;
	@ManyToOne(optional = false,targetEntity = Fillblanks.class)
	@JoinColumn(name="fillblanks_id")
	private Fillblanks fillblankId;
	
	/*考试题库表*/
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER) // 指定多对多关系 //默认懒加载,只有调用getter方法时才加载数据
	@Cascade(value = { CascadeType.SAVE_UPDATE }) // 设置级联关系
	@JoinTable(name = "exam_questiontb", // 指定第三张中间表名称
			joinColumns = { @JoinColumn(name = "examquestiontb_question_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "examquestiontb_examinfo_id") })
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<Examinfo> eSet = new HashSet<Examinfo>();
}
