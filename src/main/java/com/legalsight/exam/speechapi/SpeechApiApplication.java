package com.legalsight.exam.speechapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "LegalSight - Speech API Documentation", version = "1.0", description = "This API documentation contains the detailed specification for Speech API"),
		servers = {@Server(url = "/", description = "Default Server URL")})
public class SpeechApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeechApiApplication.class, args);
	}

}
