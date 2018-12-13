package com.lwj.springcloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.lwj.springcloud.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>,JpaSpecificationExecutor<Question> {

}
