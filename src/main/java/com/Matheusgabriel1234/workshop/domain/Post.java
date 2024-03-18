package com.Matheusgabriel1234.workshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.Matheusgabriel1234.workshop.dto.AutorDto;
import com.Matheusgabriel1234.workshop.dto.Comments;
@Document(collection="Post")
public class Post implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
private String  id;
private Date date;
private String title;
private String body;
private AutorDto author;

List<Comments> comments = new ArrayList<>();




public Post() {
	
}

public Post(String id, Date date, String title, String body, AutorDto author) {
	super();
	this.id = id;
	this.date = date;
	this.title = title;
	this.body = body;
	this.author = author;
}


public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getBody() {
	return body;
}

public void setBody(String body) {
	this.body = body;
}

@Override
public int hashCode() {
	return Objects.hash(id);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Post other = (Post) obj;
	return Objects.equals(id, other.id);
}

public AutorDto getAuthor() {
	return author;
}

public void setAuthor(AutorDto author) {
	this.author = author;
}

public List<Comments> getComments() {
	return comments;
}

public void setComments(List<Comments> comments) {
	this.comments = comments;
}



 





}
