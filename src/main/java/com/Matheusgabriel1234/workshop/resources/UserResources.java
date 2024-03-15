package com.Matheusgabriel1234.workshop.resources;



import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Matheusgabriel1234.workshop.domain.Post;
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
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDto objDTO){
Users obj = service.fromDto(objDTO);
obj = service.insert(obj);
URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
return ResponseEntity.created(uri).build();

				
		
	}
  
@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
public ResponseEntity<Void> deleteById(@PathVariable String id){
			service.delete(id);
		return 	ResponseEntity.noContent().build();
			
		}

@RequestMapping(value="/{id}", method=RequestMethod.PUT)
public ResponseEntity<Void> update(@PathVariable String id,@RequestBody UserDto ObjDTO){
Users obj = service.fromDto(ObjDTO);
obj.setId(id);
obj = service.update(obj);

return ResponseEntity.noContent().build();
			
	
}

@RequestMapping(value="/{id}/posts", method=RequestMethod.GET)
public ResponseEntity<List<Post>> findPost(@PathVariable String id){
Users obj = service.findById(id);
return ResponseEntity.ok().body(obj.getPost());
	
			
	
}

	
	
}