package com.yashasvi.ums.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

	final String GET = "GET";
	final String POST = "POST";
	final String DELETE = "DELETE";
	final String PUT = "PUT";

	public WebMvcConfigurer corsConfigurer() {

		return new WebMvcConfigurer(){
		
			public void addCorsMapping(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods(GET, PUT, POST, DELETE).allowedHeaders("*")
						.allowedOriginPatterns("*").allowCredentials(true);
			}
		};
	}
}
