package com.lhf.entity;

public class ScoreSearch {
	private int scoreId;
	private String scoreCourse;
	private String scoreContent;
	private String courseName;
	public ScoreSearch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScoreSearch(int scoreId, String scoreCourse, String scoreContent, String courseName) {
		super();
		this.scoreId = scoreId;
		this.scoreCourse = scoreCourse;
		this.scoreContent = scoreContent;
		this.courseName = courseName;
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
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		return "ScoreSearch [scoreId=" + scoreId + ", scoreCourse=" + scoreCourse + ", scoreContent=" + scoreContent
				+ ", courseName=" + courseName + "]";
	}

}
