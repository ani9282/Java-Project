package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.User;

public interface MyDao {

	int addEmployee(User emp);

	List<User> getAllUser();

	int updateEmployee(User emp, int id);

	int deleteUser(int id);

	User getAllUsersById(int id);

}
