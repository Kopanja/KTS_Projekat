package com.kts.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kts.project.backend.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	User findByEmailAndIdNot(String email, Long id);

}
