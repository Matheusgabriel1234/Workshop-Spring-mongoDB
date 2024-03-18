package com.Matheusgabriel1234.workshop.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.Matheusgabriel1234.workshop.domain.Post;
import com.Matheusgabriel1234.workshop.domain.Users;
import com.Matheusgabriel1234.workshop.dto.AutorDto;
import com.Matheusgabriel1234.workshop.dto.Comments;
import com.Matheusgabriel1234.workshop.repository.PostRepository;
import com.Matheusgabriel1234.workshop.repository.UserRepository;

@Configuration
public class Config implements CommandLineRunner {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
  
	
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Override
	public void run(String... args) throws Exception {
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		// TODO Auto-generated method stub
		postRepo.deleteAll();
		repo.deleteAll();
		Users eduarda = new Users(null,"Eduarda Cecato","eduarda@gmail.com");
		Users luiza = new Users(null,"Luiza Grando","luiza@gmail.com");
		Users everton = new Users(null,"Everton Cecato","everton@gmail.com");
		repo.saveAll(Arrays.asList(eduarda,luiza,everton));
		
		Post post1 = new Post(null,sdf.parse("21/02/2024"),"Partiu viagem","Vou viajar para SC abraços",new AutorDto(luiza));
		Post post2 = new Post(null,sdf.parse("21/02/2024"),"Bom dia","Vou viajar para o RJ abraços",new AutorDto(eduarda));
		;
		
		
		Comments c1 = new Comments("Boa viagem Mano",sdf.parse("21/03/2024"),new AutorDto(eduarda));
		Comments c2 = new Comments("Aproveite",sdf.parse("19/03/2024"),new AutorDto(luiza));
		
		Comments c3 = new Comments("Boa viagem Mano",sdf.parse("22/03/2024"),new AutorDto(everton));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
        post2.getComments().addAll(Arrays.asList(c3));
		
		
		
		
		
		postRepo.saveAll(Arrays.asList(post1,post2));
		
		eduarda.getPost().addAll(Arrays.asList(post2));

		luiza.getPost().addAll(Arrays.asList(post1));
		
		repo.saveAll(Arrays.asList(eduarda,luiza));
		
	}
	

}
