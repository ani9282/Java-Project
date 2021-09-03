package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MyDao;
import com.example.demo.dao.MyDaoImpl;
import com.example.demo.model.User;

@Service
public class MyServiceImpl implements MyService {

	@Autowired
	private MyDao dao;

	public int addEmployee(User emp) {
		// TODO Auto-generated method stub
		System.out.printf("emp ------------------{}",emp);
		return dao.addEmployee(emp);
	}

	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return dao.getAllUser();
	}

	public int updateEmployee(User emp, int id) {
		// TODO Auto-generated method stub
		return dao.updateEmployee(emp,id);
	}

	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return dao.deleteUser(id);
	}

	public User getAllUsersById(int id) {
		// TODO Auto-generated method stub
		return dao.getAllUsersById(id);
	}

	

}
