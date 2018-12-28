package com.ysd.boot.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name="professionaltb")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Professional {
	@Id//实体类的主键
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//自动增长列
 	@OrderBy	//数据加载顺序
 	@Column(columnDefinition="int unsigned NOT NULL comment '备注:专业id'  ")
	private Integer professionalId;
	@Column(columnDefinition="varchar(20) comment '备注:专业名称'  ")
	private String professionalName;
	
	//院系id
	@JsonIgnore
	@JsonUnwrapped
	@ManyToOne(targetEntity = Department.class)
	@JoinColumn(name="department_id")	//副表中的外键字段名称
	private Department department;
	
	@JsonIgnore
	@OneToMany(mappedBy="professional",fetch=FetchType.LAZY,cascade=CascadeType.DETACH)
	private List<Clazz> list = new ArrayList<>();	
	
	
	
}
