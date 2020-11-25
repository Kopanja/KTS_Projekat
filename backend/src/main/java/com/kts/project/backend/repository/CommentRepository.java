package com.kts.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kts.project.backend.model.Comment;


public interface CommentRepository  extends JpaRepository<Comment, Long> {

}
