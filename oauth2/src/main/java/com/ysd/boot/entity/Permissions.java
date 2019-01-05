package com.ysd.boot.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Permissions implements Serializable{

	
	private Integer id;
	
	
	
	private String permissionValue;
	
	
	private String permissionModule;
	
	
	private String label;
	
	
	private Date permissionLastUpdateTime;
	
     private List<Permissions> children;
	

	private Boolean checked;
	
	private Boolean disabled;
	
	
}
