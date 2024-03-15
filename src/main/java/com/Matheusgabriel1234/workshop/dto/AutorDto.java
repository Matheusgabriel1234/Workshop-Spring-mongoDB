package com.Matheusgabriel1234.workshop.dto;

import java.io.Serializable;

import com.Matheusgabriel1234.workshop.domain.Post;
import com.Matheusgabriel1234.workshop.domain.Users;

public class AutorDto implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private String id;

private String nome;

public AutorDto() {
	
}

public AutorDto(Users obj) {
id = obj.getId();
nome = obj.getNome();
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}





}
