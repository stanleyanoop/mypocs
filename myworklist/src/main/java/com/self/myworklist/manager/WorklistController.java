package com.self.myworklist.manager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorklistController {

	@GetMapping("/")
	public String helloWorld() {
	    return "Hello, World!";
	}
}
