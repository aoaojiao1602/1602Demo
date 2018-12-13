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
	private int score_id;
	@Column(columnDefinition="comment '备注:所属课程 ' ")
	private String score_course;
	@Column(columnDefinition="comment '备注:内容 ' ")
	private String score_content;
	public Score() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Score(int score_id, String score_course, String score_content) {
		super();
		this.score_id = score_id;
		this.score_course = score_course;
		this.score_content = score_content;
	}
	public int getScore_id() {
		return score_id;
	}
	public void setScore_id(int score_id) {
		this.score_id = score_id;
	}
	public String getScore_course() {
		return score_course;
	}
	public void setScore_course(String score_course) {
		this.score_course = score_course;
	}
	public String getScore_content() {
		return score_content;
	}
	public void setScore_content(String score_content) {
		this.score_content = score_content;
	}
	@Override
	public String toString() {
		return "Score [score_id=" + score_id + ", score_course=" + score_course + ", score_content=" + score_content
				+ "]";
	}

}
