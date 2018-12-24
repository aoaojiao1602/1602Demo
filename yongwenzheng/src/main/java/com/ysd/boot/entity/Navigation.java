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
@Table(name="navigation")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Navigation {
	@Id	//实体类的主键
 	@GeneratedValue(strategy=GenerationType.IDENTITY)	//自动增长列
 	@OrderBy
 	@Column(columnDefinition="int unsigned NOT NULL comment '备注:'  ")
	private Integer navId;
 
 	@Column(columnDefinition="varchar(20)  NOT NULL comment '备注:分类名'  ")
	private String navName;
	
	@Column(columnDefinition="varchar(100) comment '备注:备注'  ")
	private String navRemark;
	
	@JsonIgnore
	@OneToMany(mappedBy="navigation",fetch=FetchType.LAZY,cascade=CascadeType.DETACH)
	private List<Course> list = new ArrayList<>();
	
}
