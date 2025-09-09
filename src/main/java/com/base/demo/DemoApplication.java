package com.likelion.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EnableJpaAuditing
@SpringBootApplication
public class DemoApplication {
private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner dbConnectionCheck(
			@Value("${spring.datasource.url}") String dbUrl,
			@Value("${spring.datasource.username}") String dbUsername
	) {
		return args -> {
	        logger.info("=== Database Connection Info ===");
	        logger.info("URL: {}", dbUrl);
	        logger.info("Username: {}", dbUsername);
	        logger.info("================================");
		};
	}
}
