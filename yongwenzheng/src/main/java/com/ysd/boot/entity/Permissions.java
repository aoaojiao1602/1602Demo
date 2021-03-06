package com.ysd.boot.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="permissiontb")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Permissions {

	@Id	//实体类的主键
 	@GeneratedValue(strategy=GenerationType.IDENTITY)	//自动增长列
 	@OrderBy	//数据加载顺序
 	
 	@JsonProperty("id")
 	@Column(columnDefinition="int unsigned NOT NULL comment '备注:权限自动增长主键'  ")
	private Integer permissionId;
	
	
	@Column(columnDefinition="varchar(50) comment '备注:权限值'  ")
	private String permissionValue;
	
	@Column(columnDefinition="varchar(50) comment '备注:权限模型'  ")
	private String permissionModule;
	
	@JsonProperty("label")
	@Column(columnDefinition="varchar(50) comment '备注:权限名称'  ")
	private String permissionName;
	
	@Column(columnDefinition="datetime comment '备注:权限最后修改時間'")
	private Date permissionLastUpdateTime;
	
	@JsonInclude(Include.NON_NULL)	//如果该属性为NULL则不参与序列化
	@Transient
	private List<Permissions> children;
	
	@Transient
	private Boolean checked;
	
	@Transient
	private Boolean disabled;
	
	
	
	@JsonIgnore
	@ManyToMany(cascade=javax.persistence.CascadeType.DETACH,fetch=FetchType.EAGER)
	@JoinTable(name="permissions_roles",joinColumns={@JoinColumn(name="permissions_roles_id")},
	inverseJoinColumns= {@JoinColumn(name="roles_permissions_id")})
    private Set<Roles> setRoles=new HashSet<Roles>();
}
