package com.procare.care;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan("com.procare.controller")
@ComponentScan("com.procare.security")
@ComponentScan("com.procare.exception")
@ComponentScan("com.procare.model")
@ComponentScan("com.procare.config")

@EntityScan("com.procare.model")

@EnableJpaRepositories("com.procare.repository")
@SpringBootApplication
public class CareApplication {

	public static void main(String[] args) {
		SpringApplication.run(CareApplication.class, args);
	}

}
