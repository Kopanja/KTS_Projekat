package com.kts.project.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kts.project.backend.model.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
	
	public List<Subscription> findByUserId(Long id);
	
	public List<Subscription> findByCulturalOfferId(Long id);

}
