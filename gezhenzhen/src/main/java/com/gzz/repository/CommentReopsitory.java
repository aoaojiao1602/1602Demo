package com.gzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gzz.entity.Comment;

public interface CommentReopsitory extends JpaRepository<Comment, Integer>{

}
