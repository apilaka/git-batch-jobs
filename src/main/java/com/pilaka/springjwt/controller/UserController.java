package com.pilaka.springjwt.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pilaka.springjwt.entity.Employee;
import com.pilaka.springjwt.entity.Users;
import com.pilaka.springjwt.service.UserService;

@RestController
@RequestMapping("/api/v2")
@EnableAutoConfiguration
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/listUsers")
	public CompletableFuture<List<Users>> greetUser() {
		return CompletableFuture.completedFuture(userService.allUser());
		
	}
	

	@GetMapping("/bye")
	public ResponseEntity<String> goodBy() {
	return ResponseEntity.ok("Ok See you again");
	
	}
	
	@GetMapping("/listAllUsers")
	public CompletableFuture<List<Users>> listUsers() {
		return CompletableFuture.completedFuture(userService.listUsers());
		
	}
	@PostMapping("/loadUsers")
	public String loadUsers() {
		return userService.loadUsers();
		
	}
	@RequestMapping(value = "/addUserList", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Users> addUserList(@RequestBody List<Users> users) {
		users.forEach(user->{
			userService.addUser(user);
		});
	
		return new ResponseEntity<>(HttpStatus.OK);

	}	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Users> addUser(@RequestBody Users user) {
		userService.addUser(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);

	}
	
	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable("userId" ) long userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);

	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<Users> updateUser(@RequestBody Users user) {
		userService.addUser(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);

	}
	

	

}


