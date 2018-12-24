package com.ysd.boot.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="departmenttb")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	@Id//实体类的主键
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//自动增长列
 	@OrderBy	//数据加载顺序
 	@Column(columnDefinition="int unsigned NOT NULL comment '备注:院系id'  ")
	private Integer departmentId;
	@Column(columnDefinition="varchar(20) comment '备注:院系名称'  ")
	private String departmentName;
	
	//学校id
	@JsonIgnore
	@JsonUnwrapped
	@ManyToOne(targetEntity = School.class)
	@JoinColumn(name="school_id")	//副表中的外键字段名称
	private School school;
	
	@JsonIgnore
	@OneToMany(mappedBy="department",fetch=FetchType.LAZY,cascade=CascadeType.DETACH)
	private List<Professional> listProfessional = new ArrayList<>();	
}
