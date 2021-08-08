package com.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.service.MyService;

@Controller
public class MyController
{
	
	@Autowired
	private MyService myService;
	
	
	@RequestMapping("/")
	public String signin()
	{
		return "index";
	}
	
	
	
}
