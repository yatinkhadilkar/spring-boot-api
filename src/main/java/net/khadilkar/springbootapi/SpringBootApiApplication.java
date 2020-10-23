package net.khadilkar.springbootapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class SpringBootApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiApplication.class, args);
	}

	@Value( "${DB_USERNAME}" )
	String DB_USERNAME;

	@GetMapping("/")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {

		System.out.println("Environment Variables ..."+ DB_USERNAME);
		return String.format("Hello %s!", name);
	}

}
