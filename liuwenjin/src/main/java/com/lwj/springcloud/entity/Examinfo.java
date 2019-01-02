package com.lwj.springcloud.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "examinfotb")
@Getter
@Setter
//考试信息表
public class Examinfo {
	@Id // 指定主键 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:自动增长主键'")
	private Integer exId;
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(columnDefinition="TIMESTAMP NOT NULL comment '备注:考试开始时间'")
	private Date startTime;
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(columnDefinition="TIMESTAMP NOT NULL comment '备注:考试结束时间'")
	private Date endTime;
	@Column(columnDefinition="varchar(100) NOT NULL comment '备注:试卷名'")
	private String paperName;	
	@Column(columnDefinition="int NOT NULL comment '备注:持续时间'")
	private Integer cxTime;
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
	@Column(columnDefinition="TIMESTAMP",nullable=false,updatable=false,insertable=false)
	private Timestamp createTime;
	@Column(columnDefinition="int comment '备注:教师Id'")
	private Integer teacherId;
	@Column(columnDefinition="int comment '备注:选择题数量'")
	private Integer optionNum;
	@Column(columnDefinition="int comment '备注:判断题数量'")
	private Integer judgeNum;
	@Column(columnDefinition="int comment '备注:填空题数量'")
	private Integer fillblankNum;
	@Column(columnDefinition="int comment '备注:分数'")
	private Integer examScore;
	@Column(columnDefinition="int comment '备注:课程id'")
	private Integer kId;
	@Column(columnDefinition="varchar(20) comment '备注:考试类型'")
	private String examType;
	@JsonIgnore
	@OneToMany(mappedBy="examinfo",fetch=FetchType.LAZY)
	private List<StudentExamInfo> studentExamInfo=new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER) // 指定多对多关系 //默认懒加载,只有调用getter方法时才加载数据
	@Cascade(value = { CascadeType.SAVE_UPDATE }) // 设置级联关系
	@JoinTable(name = "exam_questiontb", // 指定第三张中间表名称
			joinColumns = { @JoinColumn(name = "examquestiontb_examinfo_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "examquestiontb_question_id") })
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<Question> qSet = new HashSet<Question>();
}
