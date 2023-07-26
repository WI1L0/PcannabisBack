package com.cannabis.BackCannabis;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BackCannabisApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackCannabisApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return  new ModelMapper();
	}

//	@Configuration
//	public class CorsConfig {
//		@Bean
//		public WebMvcConfigurer corsConfigurer() {
//			return new WebMvcConfigurer() {
//				@Override
//				public void addCorsMappings(CorsRegistry registry) {
//					registry.addMapping("/cbd/**")
//							.allowedOrigins("http://localhost:4200")
//							.allowedMethods("GET", "POST", "PUT", "DELETE");
////							.allowedHeaders("*")
////							.allowCredentials(false)
////							.maxAge(3600);
//				}
//			};
//		}
//	}
}
