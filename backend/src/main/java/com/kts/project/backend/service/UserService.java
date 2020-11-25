package com.kts.project.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kts.project.backend.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
}
