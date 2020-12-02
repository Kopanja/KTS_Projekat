package com.kts.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kts.project.backend.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
