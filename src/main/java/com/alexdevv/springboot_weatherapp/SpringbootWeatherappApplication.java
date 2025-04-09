package com.alexdevv.springboot_weatherapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.alexdevv.springboot_weatherapp")
public class SpringbootWeatherappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWeatherappApplication.class, args);
	}

}


