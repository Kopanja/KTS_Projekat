package com.kts.project.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kts.project.backend.model.Review;
import com.kts.project.backend.model.Subscription;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

	List<Review> findByUserId(Long id);

	List<Review> findByCulturalOfferId(Long id);

}
