package com.example.demo.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.MyService;
import com.example.demo.service.MyServiceImpl;

@RestController
@RequestMapping("/api")
public class Mycontroller {
	
	@Autowired
	private MyService service;
	
	@GetMapping("demo")
	public String demo() {
		return "Welcome to my new Project";
	}
	
	@GetMapping("emp")
    public List<User> getAllUsers(){
        return service.getAllUser();
    }
	
	@GetMapping("emp/{id}")
    public User getAllUsersById(@PathVariable int id){
        return service.getAllUsersById(id);
    }
	
	
	@PostMapping("emp")
	public String addEmployee(@RequestBody User emp) {
		int result = service.addEmployee(emp);
		if(result>0) {
			return "data Added successfully";
		} else {
			return "sql query failed";
		}	
	}
	

	@PutMapping("emp/{id}")
	public String updateEmployee(@RequestBody User emp,@PathVariable int id) {
		int result = service.updateEmployee(emp,id);
		if(result>0) {
			return "data update successfully";
		} else {
			return "sql query failed";
		}
		
	}
	
	@DeleteMapping("emp/{id}")
	public String deleteUser(@PathVariable int id) {
		int result = service.deleteUser(id);
		if(result>0) {
			return "data delete successfully";
		} else {
			return "sql query failed";
		}
	}
	
	

}
