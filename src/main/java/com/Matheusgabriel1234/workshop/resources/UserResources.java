package com.Matheusgabriel1234.workshop.resources;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Matheusgabriel1234.workshop.domain.Users;


@RestController
@RequestMapping(value="/users")

public class UserResources {

	@GetMapping
	public ResponseEntity<List<Users>> findAll(){
		List<Users> list = new ArrayList<>();
		Users matheus = new Users("1","Matheus Gabriel","magaje2005@gmail.com");
		Users luiza = new Users("2", "Luiza Cecato", "luiza@gmail.com");
		list.addAll(Arrays.asList(matheus,luiza));
		return ResponseEntity.ok().body(list);
		
				
		
	}

	
}