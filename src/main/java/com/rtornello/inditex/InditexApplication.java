package com.rtornello.inditex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.rtornello.inditex.*")
@EnableJpaRepositories(basePackages = "com.rtornello.inditex.application.port.output")
public class InditexApplication {

	public static void main(String[] args) {
		System.out.println("----------HOLA PEPE----------");
		SpringApplication.run(InditexApplication.class, args);
	}

}
