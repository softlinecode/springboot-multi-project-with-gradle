package com.softlinecode.springboot.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.softlinecode.springboot.domain.Domain;

/**
 * softlinecode@gmail.com
 * @since 2016. 6. 3. 오후 6:39
 */
@SpringBootApplication
@ComponentScan
@Import(Domain.class)
@EnableAutoConfiguration
public class ApiApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "api");
		SpringApplication.run(ApiApplication.class, args);
	}
}
