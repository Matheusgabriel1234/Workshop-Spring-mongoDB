package com.Matheusgabriel1234.workshop.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.Matheusgabriel1234.workshop.domain.Users;
import com.Matheusgabriel1234.workshop.repository.UserRepository;

@Configuration
public class Config implements CommandLineRunner {

	@Autowired
	UserRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repo.deleteAll();
		Users eduarda = new Users(null,"Eduarda Cecato","eduarda@gmail.com");
		Users luiza = new Users(null,"Luiza Grando","luiza@gmail.com");
		Users everton = new Users(null,"Everton Cecato","everton@gmail.com");
		
		repo.saveAll(Arrays.asList(eduarda,luiza,everton));
	}
	

}
