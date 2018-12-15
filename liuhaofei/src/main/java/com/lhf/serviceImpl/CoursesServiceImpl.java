package com.lhf.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
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
	public int deleteCoursesById(Integer CourseId) {
		return cRepository.deleteCoursesById(CourseId);
	}

	@Override
	public int postCoursesById(Courses c) {
		return cRepository.postCoursesById(c);
	}

	@Override
	public Page<Courses> queryNameLikeAllPage(String nameLike, Integer page, Integer size) {
		Sort sort = new Sort(Sort.Direction.ASC, "CourseId"); 
	    Pageable pageable = new PageRequest(page, size, sort);
		return cRepository.findByCourseNameLike("%"+nameLike+"%", pageable);
	}

	
}
