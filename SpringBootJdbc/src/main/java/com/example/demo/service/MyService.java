package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface MyService {

	int addEmployee(User emp);

	List<User> getAllUser();

	int updateEmployee(User emp, int id);

	int deleteUser(int id);

	User getAllUsersById(int id);

}
