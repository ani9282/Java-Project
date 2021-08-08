package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.beans.DisplayDevice;
import com.training.dao.MyDao;
@Service
public class MyServiceImpl implements MyService {

	@Autowired
	private MyDao myDao;
	
	
	public boolean adminLogin(String username, String password) {
		return myDao.adminLogin(username,password);
		
	}


	public void savedevicename(String name) {
	      myDao.savedevicename(name);
	}


	public List<DisplayDevice> displaydevice() {
		return myDao.displaydevice();
	}

}
