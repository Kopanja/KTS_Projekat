package com.kts.project.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kts.project.backend.model.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

	
	List<Type> findAll();
	
	Type findByName(String name);

	Type findByNameAndIdNot(String name, Long id);
	
	
}
