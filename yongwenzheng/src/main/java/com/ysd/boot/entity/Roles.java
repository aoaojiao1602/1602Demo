package com.ysd.boot.entity;

import java.sql.Timestamp;
import java.util.Date;
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
@Table(name="roletb")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Roles {
	
	@Id	//实体类的主键
 	@GeneratedValue(strategy=GenerationType.IDENTITY)	//自动增长列
 	@OrderBy	//数据加载顺序
 	@Column(columnDefinition="int unsigned NOT NULL comment '备注:角色自动增长主键'  ")
	private Integer rolesId;
	@Column(columnDefinition="varchar(20)  NOT NULL comment '备注:角色名称'  ")
	private String rolesName;
	
	@Column(columnDefinition="varchar(200) comment '备注:备注'  ")
	private String rolesExplan;
	
	@Column(columnDefinition="TIMESTAMP",nullable=false,insertable=false)
	private Timestamp rolesCreateTime;
	
	@Column(columnDefinition="datetime comment '备注:角色最后修改时间'")
	private Date rolesLastUpdateTime;

	@JsonIgnore
	@ManyToMany(cascade=javax.persistence.CascadeType.DETACH,fetch=FetchType.EAGER)
	@JoinTable(name="users_roles",joinColumns={@JoinColumn(name="roles_users_id")},
	inverseJoinColumns= {@JoinColumn(name="users_roles_id")})
	private Set<Users> setUsers=new HashSet<Users>();
	
	
	
	@JsonIgnore
	@ManyToMany(cascade=javax.persistence.CascadeType.DETACH,fetch=FetchType.EAGER)
	@JoinTable(name="permissions_roles",joinColumns={@JoinColumn(name="roles_permissions_id")},
	inverseJoinColumns= {@JoinColumn(name="permissions_roles_id")})
	private Set<Permissions> setPermissions=new HashSet<Permissions>();
	
	
	@JsonIgnore
	@ManyToMany(cascade=javax.persistence.CascadeType.DETACH,fetch=FetchType.EAGER)	
	@JoinTable(name="module_roles",joinColumns={@JoinColumn(name="roles_module_id")},
	inverseJoinColumns= {@JoinColumn(name="module_roles_id")})
    private Set<Module> setModule=new HashSet<Module>();
}
