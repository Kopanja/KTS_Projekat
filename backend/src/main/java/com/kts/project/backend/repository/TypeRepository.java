package com.kts.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kts.project.backend.model.Type;
public interface TypeRepository extends JpaRepository<Type, Long> {

}
