package com.ryum.react.example.service;

import org.springframework.stereotype.Service;

import com.ryum.react.example.dto.CommentDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Comment API Service Class
 * 
 * @author ryum
 */
@Service
public class CommentService {

	private List<CommentDto> comments = new ArrayList<CommentDto>();

	/**
	 * Default Data
	 */
	public CommentService() {
		comments.add(new CommentDto("Peter Parker", "This is a comment."));
		comments.add(new CommentDto("John Doe", "This is *another* comment."));
	}

	public List<CommentDto> getComments() {
		return comments;
	}

	public List<CommentDto> addComment(CommentDto comment) {
		comments.add(comment);
		return comments;
	}
}
