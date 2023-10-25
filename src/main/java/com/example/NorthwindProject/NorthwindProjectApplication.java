package com.example.NorthwindProject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NorthwindProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NorthwindProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialization() {
		return args -> {
			System.out.println("Rodando...");
		};
	}

}
