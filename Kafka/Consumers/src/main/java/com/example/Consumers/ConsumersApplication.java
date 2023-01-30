package com.example.Consumers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ConsumersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumersApplication.class, args);
	}

}
