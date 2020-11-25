package com.kts.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kts.project.backend.model.Subscription;


public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

}
