package com.example.openai.test.testOpenAiApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class TestOpenAiAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestOpenAiAppApplication.class, args);
	}

}
