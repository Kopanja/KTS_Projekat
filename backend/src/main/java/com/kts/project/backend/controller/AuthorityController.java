package com.kts.project.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kts.project.backend.service.AuthorityService;


@RestController
@RequestMapping(value="api/authority")
public class AuthorityController {

	@Autowired
	private AuthorityService authorityService;
}
