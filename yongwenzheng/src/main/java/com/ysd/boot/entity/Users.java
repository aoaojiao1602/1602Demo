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
@Table(name="userstb")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	
	@Id	//实体类的主键
 	@GeneratedValue(strategy=GenerationType.IDENTITY)	//自动增长列
 	@OrderBy	//数据加载顺序
 	@Column(columnDefinition="int unsigned NOT NULL comment '备注:用户自动增长主键'  ")
	private Integer usersId;
	
	@Column(columnDefinition="varchar(20)  NOT NULL comment '备注:用户姓名'  ")
	private String usersName;
	
	@Column(columnDefinition="varchar(50) NOT NULL comment '备注:用户密碼'  ")
	private String usersPassword;
	
	@Column(columnDefinition="int unsigned  DEFAULT 0 comment '备注:用户是否锁定'")
	private Integer usersIsLockout;
	
	//用户创建时间
	@Column(columnDefinition="TIMESTAMP",nullable=false,insertable=false)
	private Timestamp usersCreateTime;
	
	@Column(columnDefinition="datetime comment '备注:用户修改時間'")
	private Date usersUpdateTime;
	
	@Column(columnDefinition="datetime comment '备注:用户最后登录时间'")
	private Date usersLastLoginTime;
	
	@Column(columnDefinition="varchar(20) comment '备注:用户登录ip'")
	private String usersLastLoginIp;

	@Column(columnDefinition="int unsigned DEFAULT 0 comment '备注:用户锁定次数'")
	private Integer usersPassWrongCount;
	
	@Column(columnDefinition="datetime comment '备注:用户最后锁定时间'")
	private Date usersLockOutTime;
	
	
	@JsonIgnore
	@ManyToMany(cascade=javax.persistence.CascadeType.DETACH,fetch=FetchType.EAGER)	
	@JoinTable(name="users_roles",joinColumns={@JoinColumn(name="users_roles_id")},
	inverseJoinColumns= {@JoinColumn(name="roles_users_id")})
    private Set<Roles> setRoles=new HashSet<Roles>();
	
	
	@JsonIgnore
	@ManyToMany(cascade=javax.persistence.CascadeType.DETACH,fetch=FetchType.EAGER)	
	@JoinTable(name="users_clazz",joinColumns={@JoinColumn(name="users_clazz_id")},
	inverseJoinColumns= {@JoinColumn(name="clazz_users_id")})
    private Set<Clazz> setClazz=new HashSet<Clazz>();
	
	
	
}
