package com.ysd.boot.entity;

import java.io.Serializable;
import java.util.Date;

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

	
	private Integer permissionId;
	
	
	
	private String permissionValue;
	
	
	private String permissionModule;
	
	
	private String permissionName;
	
	
	private Date permissionLastUpdateTime;
	
	
}
