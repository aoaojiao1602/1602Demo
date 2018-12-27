package com.lhf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="score")
public class Score {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int  NOT NULL comment '备注:评分标准编号'  ")
	private int scoreId;
	@Column(columnDefinition="int comment '备注:所属课程 ' ")
	private int scoreCourse;
	@Column(columnDefinition="varchar(100) comment '备注:内容 ' ")
	private String scoreContent;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="courses_score",unique = true)
	private Courses courses;
	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Score(int scoreId, int scoreCourse, String scoreContent, Courses courses) {
		super();
		this.scoreId = scoreId;
		this.scoreCourse = scoreCourse;
		this.scoreContent = scoreContent;
		this.courses = courses;
	}

	public int getScoreId() {
		return scoreId;
	}
	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}
	
	public String getScoreContent() {
		return scoreContent;
	}
	public void setScoreContent(String scoreContent) {
		this.scoreContent = scoreContent;
	}
	public Courses getCourses() {
		return courses;
	}
	public void setCourses(Courses courses) {
		this.courses = courses;
	}

	public int getScoreCourse() {
		return scoreCourse;
	}

	public void setScoreCourse(int scoreCourse) {
		this.scoreCourse = scoreCourse;
	}

	@Override
	public String toString() {
		return "Score [scoreId=" + scoreId + ", scoreCourse=" + scoreCourse + ", scoreContent=" + scoreContent
				+ ", courses=" + courses + "]";
	}
	
	

}
