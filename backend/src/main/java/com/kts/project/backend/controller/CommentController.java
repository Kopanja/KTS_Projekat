package com.kts.project.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kts.project.backend.service.CommentService;


@RestController
@RequestMapping(value="api/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;
}
