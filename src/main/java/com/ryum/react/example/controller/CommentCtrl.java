package com.ryum.react.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ryum.react.example.dto.CommentDto;
import com.ryum.react.example.service.CommentService;

/**
 * Comment API Controller
 *  
 * @author ryum
 */
@RestController
@RequestMapping("/comments")
public class CommentCtrl {

	private CommentService service;

	@Autowired
	public CommentCtrl(CommentService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<CommentDto> getComments() {
		return service.getComments();
	}

	@RequestMapping(method = RequestMethod.POST)
	public List<CommentDto> addComment(CommentDto comment) {
		return service.addComment(comment);
	}

}
