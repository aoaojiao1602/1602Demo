package com.lwj.springcloud.entity;

import static org.hamcrest.CoreMatchers.nullValue;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Table(name = "questiontb")
@GenericGenerator(name = "qId", strategy = "increment")
@Setter
@Getter
//题库表
public class Question {
	@Id
	@GeneratedValue
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:自动增长主键'")
	private Integer qId;
	@Column(columnDefinition = "int NOT NULL comment '备注:教师id'")
	private Integer teacherId;
	@Column(columnDefinition = "int NOT NULL comment '备注:课程id'")
	private Integer courseId;
	@Column(columnDefinition = "int NULL comment '备注:章节id'")
	private Integer sectionId;
	@Column(columnDefinition = "TIMESTAMP", nullable = false, updatable = false, insertable = false)
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
	private Date createTime;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="option_id",unique = true)
	@Cascade(value = { CascadeType.ALL}) 
	private Options options;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "judges_id",unique = true)
	@Cascade(value = { CascadeType.ALL}) 
	private Judges judges;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fillblanks_id",unique = true)
	@Cascade(value = { CascadeType.ALL}) 
	private Fillblanks fillblanks;
	@Transient
	private Object quest;
	@Transient
	private Object tx;
	/* 考试题库表 */
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER) // 指定多对多关系 //默认懒加载,只有调用getter方法时才加载数据
	@Cascade(value = { CascadeType.SAVE_UPDATE }) // 设置级联关系
	@JoinTable(name = "exam_questiontb", // 指定第三张中间表名称
			joinColumns = { @JoinColumn(name = "examquestiontb_question_id") }, inverseJoinColumns = {
					@JoinColumn(name = "examquestiontb_examinfo_id") })
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<Examinfo> eSet = new HashSet<Examinfo>();

	public Object getQuest() {
		if (this.options != null) {
			quest=options;
		}
		if (this.judges != null) {
			quest=judges;
		}
		if (this.fillblanks!= null) {
			quest=fillblanks;
		}
		return quest;
	}

}
