package com.hwg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 敏感词存储	
 * @Description 
 * @author HJiong
 * @time 2019年1月4日 上午10:37:12
 */
@Entity
@Table(name="sensitivetb")
public class Sensitive {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int unsigned NOT NULL comment '备注:主键'")
	private Integer sId;
	
	@Column(columnDefinition = "varchar(100) NOT NULL comment '备注:词汇内容'")
	private String content;

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}
