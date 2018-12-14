package com.lhf.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lhf.entity.Courses;
import com.lhf.repository.CoursesRepository;
import com.lhf.service.CoursesService;
@Service
public class CoursesServiceImpl implements CoursesService {
	@Autowired
	private CoursesRepository cRepository;

	@Override
	public int putCourses(Courses c) {
		return cRepository.putCourses(c);
	}

	@Override
	public int deleteCoursesById(Integer Course_id) {
		return cRepository.deleteCoursesById(Course_id);
	}

	@Override
	public int postCoursesById(Courses c) {
		return cRepository.postCoursesById(c);
	}

}
