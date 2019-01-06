package com.hwg.entity;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.Data;

@Document(indexName = "lhf",type="doc")
@Data
public class CourseEs {
	
	@Id
	private Integer course_id;
	@Field(type = FieldType.Date)
	private Date course_create_time;
	@Field(type = FieldType.text)
	private String course_creator;
	@Field(type = FieldType.Date)
	private Date course_editor_time;
	@Field(type = FieldType.text)
	private String course_name;
	@Field(type = FieldType.text)
	private String course_remark;
	@Field(type = FieldType.text)
	private String course_state;

}
