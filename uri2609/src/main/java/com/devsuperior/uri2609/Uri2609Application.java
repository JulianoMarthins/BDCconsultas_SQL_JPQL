package com.devsuperior.uri2609;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import com.devsuperior.uri2609.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("\nConsulta ao banco de dados com o SQL");

		List<CategorySumProjection> list = repository.searchSQL();
		List<CategorySumDTO> resultSQL = list.stream().map(CategorySumDTO::new).collect(Collectors.toList());

		System.out.println("\n");

		for (CategorySumDTO obj : resultSQL) {
			System.out.println(obj);
		}

		System.out.println("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");

		System.out.println("Consulta ao banco de dados com JPQL\n");


		List<CategorySumDTO> resultJPQL = repository.searchJPQL();

		System.out.println("\n");

		for (CategorySumDTO obj : resultJPQL){
			System.out.println(obj);
		}


	}
}
