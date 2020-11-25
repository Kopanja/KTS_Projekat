package com.kts.project.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.project.backend.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	PostRepository postRepo;
}
