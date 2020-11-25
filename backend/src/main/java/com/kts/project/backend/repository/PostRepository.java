package com.kts.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kts.project.backend.model.Post;


public interface PostRepository extends JpaRepository<Post, Long> {

}
