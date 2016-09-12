package com.ryum.react.example.dto;

import java.util.Date;

/**
 * Comment Data Transfer Object
 * 
 * @author ryum
 */
public class CommentDto {

	private int id;
	private String author;
	private String text;

	public CommentDto() {

	}

	public CommentDto(String author, String text) {
		this.author = author;
		this.text = text;
		setId();
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
		setId();
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	/**
	 * ID is Primary key
	 */
	private void setId() {
		id = (int) (this.author.hashCode() + new Date().getTime());
	}

	public int getId() {
		return id;
	}
}
