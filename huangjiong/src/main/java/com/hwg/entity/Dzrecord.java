package com.hwg.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description 点赞记录实体
 * @author HJiong
 * @time 2019年1月5日 下午10:01:57
 */
@Entity
@Table(name = "dzrecordtb")
public class Dzrecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:主键'")
	private Integer dId;
	@Column(columnDefinition = "int NOT NULL comment '备注:用户id'")
	private Integer userId;
	@Column(columnDefinition = "int NOT NULL comment '备注:评价id'")
	private Integer commentId;
	@Column(columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '备注:创建时间'")
	private Timestamp crateTime;
	public Integer getdId() {
		return dId;
	}
	public void setdId(Integer dId) {
		this.dId = dId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Timestamp getCrateTime() {
		return crateTime;
	}
	public void setCrateTime(Timestamp crateTime) {
		this.crateTime = crateTime;
	}
	
	
}
