package com.devsuperior.uri2611;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.porjections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {

	@Autowired
	private MovieRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<MovieMinProjection> list = repository.searchSQL("Action");

		List<MovieMinDTO> result = list.stream().map(MovieMinDTO::new).collect(Collectors.toList());

		System.out.println("\nConsulta via SQL");

		for(MovieMinDTO obj : result){
			System.out.println(obj);
		}


		System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");

		
		List<MovieMinDTO> result2 = repository.searchJPQL("Action");

		System.out.println("\nConsulta via JPQL: \n");

		for (MovieMinDTO obj : result2){
			System.out.println(obj);
		}

	}
}
