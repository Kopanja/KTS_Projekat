package com.kts.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kts.project.backend.model.COLocation;

public interface LocationRepository extends JpaRepository<COLocation, Long> {

}
