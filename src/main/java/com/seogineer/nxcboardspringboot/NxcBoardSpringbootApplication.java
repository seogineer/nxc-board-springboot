package com.seogineer.nxcboardspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NxcBoardSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(NxcBoardSpringbootApplication.class, args);
	}

}
