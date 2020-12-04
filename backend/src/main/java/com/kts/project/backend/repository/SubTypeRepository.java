package com.kts.project.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kts.project.backend.model.SubType;
@Repository
public interface SubTypeRepository extends JpaRepository<SubType, Long> {

	List<SubType> findAll();
	
	SubType findByName(String name);
}
