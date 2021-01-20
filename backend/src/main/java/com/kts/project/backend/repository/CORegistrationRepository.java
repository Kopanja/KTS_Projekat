package com.kts.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kts.project.backend.model.CORegistrationForm;

public interface CORegistrationRepository extends JpaRepository<CORegistrationForm, Long> {

	CORegistrationForm findByName(String name);

}
