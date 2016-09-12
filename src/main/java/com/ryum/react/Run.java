package com.ryum.react;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Application Runnable Class
 * 
 * @author ryum
 */
@SpringBootApplication
public class Run extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Run.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Run.class, args);
	}
}