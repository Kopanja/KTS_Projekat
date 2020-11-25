package com.kts.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kts.project.backend.model.Content;


public interface ContentRepository  extends JpaRepository<Content, Long> {

}
