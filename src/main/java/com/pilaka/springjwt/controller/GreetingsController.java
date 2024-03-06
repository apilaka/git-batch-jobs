package com.pilaka.springjwt.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api/v1/user")
public class GreetingsController {
	

	
	@GetMapping("/hello1")
	public ResponseEntity<String> sayHello() {
		return ResponseEntity.ok("Hello Useruuuuuuuuuuuuuu");
		
	}
	@GetMapping("/bye")
	public ResponseEntity<String> goodBy() {
	return ResponseEntity.ok("Ok See you again");
	
	}

}


