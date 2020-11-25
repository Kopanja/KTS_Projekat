package com.kts.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kts.project.backend.model.Review;


public interface ReviewRepository extends JpaRepository<Review, Long> {

}
