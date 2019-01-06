package com.hwg.controller;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hwg.entity.CourseEs;
import com.hwg.repository.CourseEsRepository;

@RestController
@RequestMapping("coursees")
public class CourseEsController {
	
	@Autowired
	private CourseEsRepository cDao;
	
	/**
	 * ES分词查询
	 * @param id
	 * @return
	 */
	@RequestMapping("/findCourse")
	public ResponseEntity<List<CourseEs>> findCourse(String name) {
		List<CourseEs> list = new ArrayList<CourseEs>();
		Iterable<CourseEs> iterable = cDao.search(QueryBuilders.matchQuery("course_name", name));//对查询条件字符分词[使用中文分词器]
		iterable.forEach(u -> list.add(u) );
		return new ResponseEntity<List<CourseEs>>(list, HttpStatus.OK);
	}

}
