package com.lhf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="score")
public class Score {
	@Id
	@GeneratedValue
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:评分标准编号'  ")
	private int scoreId;
	@Column(columnDefinition="varchar(50) comment '备注:所属课程 ' ")
	private String scoreCourse;
	@Column(columnDefinition="varchar(100) comment '备注:内容 ' ")
	private String scoreContent;
	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Score(int scoreId, String scoreCourse, String scoreContent) {
		super();
		this.scoreId = scoreId;
		this.scoreCourse = scoreCourse;
		this.scoreContent = scoreContent;
	}
	public int getScoreId() {
		return scoreId;
	}
	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}
	public String getScoreCourse() {
		return scoreCourse;
	}
	public void setScoreCourse(String scoreCourse) {
		this.scoreCourse = scoreCourse;
	}
	public String getScoreContent() {
		return scoreContent;
	}
	public void setScoreContent(String scoreContent) {
		this.scoreContent = scoreContent;
	}
	@Override
	public String toString() {
		return "Score [scoreId=" + scoreId + ", scoreCourse=" + scoreCourse + ", scoreContent=" + scoreContent + "]";
	}
	

}
