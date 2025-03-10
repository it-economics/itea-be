package com.soprasteria.iteabe;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "Welcome to itea-be!";
	}

}
