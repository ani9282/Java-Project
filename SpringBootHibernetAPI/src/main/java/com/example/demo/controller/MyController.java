package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

@RestController
@RequestMapping("/api")
public class MyController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/demo")
	public String demo() {
		return "Welcome to spring boot Hibernet API Project";
	}

	@GetMapping("/user")
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	// get user by id
	@GetMapping("user/{id}")
	public Optional<User> getUserById(@PathVariable(value = "id") long userId) {
		return this.userRepository.findById(userId);
	}

	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return this.userRepository.save(user);
	}
	
//	 update user
		@PutMapping("user/{id}")
		public User updateUser(@RequestBody User user, @PathVariable ("id") long userId) {
			 User existingUser = userRepository.getOne(userId);
			 existingUser.setFirstName(user.getFirstName());
			 existingUser.setLastName(user.getLastName());
			 existingUser.setEmail(user.getEmail());
			 return this.userRepository.save(existingUser);
		}
		

        

	// delete user by id
	@DeleteMapping("user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") long userId) {
		this.userRepository.deleteById(userId);
		return ResponseEntity.ok().build();
	}
	
	

}
