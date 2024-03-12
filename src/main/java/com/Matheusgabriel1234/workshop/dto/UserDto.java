package com.Matheusgabriel1234.workshop.dto;

import java.io.Serializable;
import java.util.Objects;

import com.Matheusgabriel1234.workshop.domain.Users;

public class UserDto implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String id;
private String nome;
private String email;

public UserDto() {
	
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
	UserDto other = (UserDto) obj;
	return Objects.equals(id, other.id);
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public UserDto(Users obj) {
	id = obj.getId();
	nome = obj.getNome();
	email = obj.getEmail();
	
}


}
