package com.gzz.entity;

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
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="moduletb")
public class Module {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(columnDefinition="int unsigned NOT NULL comment '备注：模块自动增长主键'")
	@JsonProperty(value = "id")
	private Integer moduleId;
	@Column(length=20)
	private String moduleName;
	@Column(length=100)
	private String moduleTitle;
	@OneToMany(mappedBy="module",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Project> project=new ArrayList<>();
	@Transient
	private Integer Exet1;
	@Transient
	private String Exet2;
	
	

}
