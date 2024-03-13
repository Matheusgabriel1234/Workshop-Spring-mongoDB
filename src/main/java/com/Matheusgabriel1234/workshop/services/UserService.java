package com.Matheusgabriel1234.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Matheusgabriel1234.workshop.domain.Users;
import com.Matheusgabriel1234.workshop.repository.UserRepository;
import com.Matheusgabriel1234.workshop.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	public List<Users> findAll(){
		return repo.findAll();
	}
	
	public Users findById(String id){
		Users user = repo.findById(id).orElse(null);
		if(user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
		
		
	}

}
