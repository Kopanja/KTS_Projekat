package com.kts.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kts.project.backend.model.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
