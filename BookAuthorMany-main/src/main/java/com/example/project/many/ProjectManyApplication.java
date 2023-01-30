package com.example.project.many;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class ProjectManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManyApplication.class, args);
	}

}
