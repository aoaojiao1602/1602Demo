package com.hwg.repository;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.hwg.entity.CourseEs;

public interface CourseEsRepository extends ElasticsearchRepository<CourseEs, Integer> {

}
