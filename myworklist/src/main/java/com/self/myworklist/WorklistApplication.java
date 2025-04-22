package com.self.myworklist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan(basePackages = {"com.self.myworklist.data"})
public class WorklistApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(WorklistApplication.class, args);
	}

}
