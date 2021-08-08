package com.training.service;

import java.util.List;

import com.training.beans.DisplayDevice;

public interface MyService {

	boolean adminLogin(String username, String password);

	void savedevicename(String name);

	List<DisplayDevice> displaydevice();

}
