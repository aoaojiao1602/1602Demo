package com.ysd.boot.entity;

import java.util.HashSet;
import java.util.Set;

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
@Table(name="clazztb")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Clazz {
	@Id//实体类的主键
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//自动增长列
 	@OrderBy	//数据加载顺序
 	@Column(columnDefinition="int unsigned NOT NULL comment '备注:班级id'  ")
	private Integer classId;
	@Column(columnDefinition="varchar(20) comment '备注:班级名称'  ")
	private String className;
	
	//专业id
	@JsonIgnore
	@JsonUnwrapped
	@ManyToOne(targetEntity =Professional.class)
	@JoinColumn(name="professional_id")	//副表中的外键字段名称
	private Professional professional;
	
	@JsonIgnore
	@ManyToMany(cascade=javax.persistence.CascadeType.DETACH,fetch=FetchType.EAGER)	
	@JoinTable(name="users_clazz",joinColumns={@JoinColumn(name="clazz_users_id")},
	inverseJoinColumns= {@JoinColumn(name="users_clazz_id")})
    private Set<Users> setUsers=new HashSet<Users>();
}
