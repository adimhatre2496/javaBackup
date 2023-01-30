package com.fakeapi.fakeApiRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FakeApiRequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FakeApiRequestApplication.class, args);
	}

	@Bean
	public RestTemplate postRestTemplate()
	{
		return  new RestTemplate();
	}

}
