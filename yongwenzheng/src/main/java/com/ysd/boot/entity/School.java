package com.ysd.boot.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="schooltb")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class School {
	@Id//实体类的主键
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//自动增长列
 	@OrderBy	//数据加载顺序
	@Column(columnDefinition="int unsigned comment '备注:学校id'  ")
 	private int schoolId;
	@Column(columnDefinition="varchar(20) comment '备注:学校名称'  ")
	private String schoolName;
	
	@JsonIgnore
	@OneToMany(mappedBy="school",fetch=FetchType.LAZY,cascade=CascadeType.DETACH)
	private List<Department> listDepartment = new ArrayList<>();
}
