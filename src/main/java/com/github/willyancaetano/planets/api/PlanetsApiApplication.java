package com.github.willyancaetano.planets.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.validation.ConstraintViolationProblemModule;

@SpringBootApplication
@EnableMongoRepositories
@EnableFeignClients
@EnableAutoConfiguration(exclude = ErrorMvcAutoConfiguration.class)
public class PlanetsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanetsApiApplication.class, args);
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper().registerModules(
			new ProblemModule(),
			new ConstraintViolationProblemModule());
	}
}
