package com.example.ecodirve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories
@SpringBootApplication
public class EcoDirveApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcoDirveApplication.class, args);
	}

}
