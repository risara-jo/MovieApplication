package com.example.MovieApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieApplication {

	public static void main(String[] args) {
		System.out.println(" Starting MovieApplication...");
		SpringApplication.run(MovieApplication.class, args);
	}

}
