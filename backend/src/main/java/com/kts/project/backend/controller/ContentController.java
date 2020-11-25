package com.kts.project.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kts.project.backend.service.ContentService;

@RestController
@RequestMapping(value="api/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
}
