package com.nd2.assignwork;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ND2Application {

	public static void main(String[] args) {
		SpringApplication.run(ND2Application.class, args);
	}


	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
}
