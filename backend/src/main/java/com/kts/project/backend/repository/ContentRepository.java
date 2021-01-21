package com.kts.project.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kts.project.backend.model.Content;

@Repository
public interface ContentRepository  extends JpaRepository<Content, Long> {

	List<Content> findByUserId(Long id);

}
