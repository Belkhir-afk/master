package com.demo.repository.test;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "com.demo.business", "com.demo", "com.demo.repository"})
@EnableJpaRepositories(basePackages = {"com.demo.repository"})
@EntityScan( "com.demo.model.persitent") 
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
}

