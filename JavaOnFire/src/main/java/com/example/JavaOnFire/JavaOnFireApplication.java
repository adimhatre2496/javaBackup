package com.example.JavaOnFire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "xyz.demo.Java8.service.AnimeService")
@ComponentScan(basePackages = "xyz.demo.Java8.service.Testeer")

public class JavaOnFireApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaOnFireApplication.class, args);
	}

}
