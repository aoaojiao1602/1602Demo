package com.ysd.boot.entity;

import java.sql.Date;
import java.sql.Timestamp;
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
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="moduletb")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Module {
	@Id	//实体类的主键
 	@GeneratedValue(strategy=GenerationType.IDENTITY)	//自动增长列
 	@OrderBy	//数据加载顺序
 	@Column(columnDefinition="int unsigned NOT NULL comment '备注:模块ID自动增长主键'  ")
	private Integer moduleId;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:父id'  ")
	private Integer parentId;
	@Column(columnDefinition="varchar(20)  NOT NULL comment '备注:模块姓名'  ")
	private String moduleName;
	@Column(columnDefinition="int unsigned NOT NULL comment '备注:模块权重'  ")
	private Integer moduleWeight;
	@Column(columnDefinition="TIMESTAMP",nullable=false,insertable=false)
	private Timestamp moduleCreateTime;
	@Column(columnDefinition="datetime comment '备注:模块修改时间'")
	private Date moduleLastUpdateTime;
	@Column(columnDefinition="varchar(50) comment '备注:模块路径'  ")
	private String moduleUrl;
	
	
	
	@JsonIgnore
	@ManyToMany(cascade=javax.persistence.CascadeType.DETACH,fetch=FetchType.EAGER)	
	@JoinTable(name="module_roles",joinColumns={@JoinColumn(name="module_roles_id")},
	inverseJoinColumns= {@JoinColumn(name="roles_module_id")})
    private Set<Roles> setRoles=new HashSet<Roles>();
}
