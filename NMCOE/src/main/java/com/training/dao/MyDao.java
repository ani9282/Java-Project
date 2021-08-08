package com.training.dao;

import java.util.List;

import com.training.beans.DisplayDevice;

public interface MyDao {

	boolean adminLogin(String username, String password);

	void savedevicename(String name);

	List<DisplayDevice> displaydevice();

}
