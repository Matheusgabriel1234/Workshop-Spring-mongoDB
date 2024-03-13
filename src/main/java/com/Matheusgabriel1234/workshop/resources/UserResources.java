package com.Matheusgabriel1234.workshop.resources;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Matheusgabriel1234.workshop.domain.Users;
import com.Matheusgabriel1234.workshop.dto.UserDto;
import com.Matheusgabriel1234.workshop.services.UserService;


@RestController
@RequestMapping(value="/users")

public class UserResources {
	
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDto>> findAll(){
		List<Users> list = service.findAll();
		List<UserDto> listDto = list.stream().map(UserDto::new).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	
		
				
		
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDto> findById(@PathVariable String id){
	Users obj = service.findById(id);
	return ResponseEntity.ok().body(new UserDto(obj));
		
				
		
	}

	
}