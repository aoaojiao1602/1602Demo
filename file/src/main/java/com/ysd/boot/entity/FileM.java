package com.ysd.boot.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="filetb")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileM {
	
	@Id	//实体类的主键
 	@GeneratedValue(strategy=GenerationType.IDENTITY)	//自动增长列
 	@OrderBy	//数据加载顺序
 	@Column(columnDefinition="int unsigned NOT NULL comment '备注:文件管理自动增长主键'  ")
	private Integer id;
	
	@Column(columnDefinition="varchar(50) comment '备注:文件现名称' ")
	private String fileName;
	
	@Column(columnDefinition="varchar(50) comment '备注:文件原名称'  ")
	private String fileOldName;
	
	@Column(columnDefinition="varchar(10) comment '备注:文件类型 ' ")
	private String fileType;
	
	@Column(columnDefinition="varchar(20) comment '备注:文件大小' ")
	private String fileSize;
	
	@Column(columnDefinition="varchar(40) comment '备注:文件地址' ")
	private String fileUrl;
	
	@Column(columnDefinition="varchar(50) comment '备注:文件时长如MP4'")
	private String fileTime;

}
