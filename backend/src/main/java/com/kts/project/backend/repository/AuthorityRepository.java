package com.kts.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kts.project.backend.model.Authority;


public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
