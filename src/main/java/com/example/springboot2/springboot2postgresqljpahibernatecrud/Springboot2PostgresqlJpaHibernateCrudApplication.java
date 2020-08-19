package com.example.springboot2.springboot2postgresqljpahibernatecrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Collections;

@Configuration
@ComponentScan
@SpringBootApplication
public class Springboot2PostgresqlJpaHibernateCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2PostgresqlJpaHibernateCrudApplication.class, args);
		SpringApplication application = new SpringApplication(Springboot2PostgresqlJpaHibernateCrudApplication.class);
		application.setDefaultProperties(Collections.singletonMap("server.port", "80"));
		application.run(args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("Gets").allowedOrigins("http://localhost:80");
			}
		};
	}
}
