package com.kts.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kts.project.backend.model.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

}
