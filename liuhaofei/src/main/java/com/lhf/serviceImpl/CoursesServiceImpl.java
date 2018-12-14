package com.lhf.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhf.repository.CoursesRepository;
import com.lhf.service.CoursesService;
@Service
public class CoursesServiceImpl implements CoursesService {
	@Autowired
	private CoursesRepository cRepository;

	@Override
	public int putCourses(String Course_category, String course_name, String course_creator, String course_remark) {
		return cRepository.putCourses(Course_category, course_name, course_creator, course_remark);
	}

}
