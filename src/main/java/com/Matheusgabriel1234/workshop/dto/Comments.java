package com.Matheusgabriel1234.workshop.dto;

import java.io.Serializable;
import java.util.Date;

public class Comments implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	private Date date;
	private AutorDto author;
	
	public Comments() {
		
	}

	public Comments(String text, Date date, AutorDto author) {
		super();
		this.text = text;
		this.date = date;
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public AutorDto getAuthor() {
		return author;
	}

	public void setAuthor(AutorDto author) {
		this.author = author;
	}
	
	

}
