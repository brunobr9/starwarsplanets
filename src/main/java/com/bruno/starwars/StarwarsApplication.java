package com.bruno.starwars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.bruno.starwars.swapi.client.SWApiClient;
import com.bruno.starwars.swapi.client.SWClientImpl;

@SpringBootApplication
public class StarwarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarwarsApplication.class, args);
	}

	@Bean
	public SWApiClient swApiClient() {
		return new SWClientImpl();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
