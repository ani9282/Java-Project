package com.training.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.training.beans.UserLogin;
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
	
	
	@RequestMapping("/register")
	public  ModelAndView userregistration(@RequestParam("fname") String fname, @RequestParam("lname") String lname,@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("dob") String dob,@RequestParam("address") String address)
	{
		
		myService.userregistration(fname,lname,username,password,dob,address);
		return new ModelAndView("signin","msg","User Registration successfully Thank You!!!"); 
	}
	
	
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam("username") String username,@RequestParam("password") String password)
	{
	
		
		
		boolean ans=myService.login(username,password);
		if(ans)
		{
			
			List<UserLogin> plist=myService.getAllData();
			return new ModelAndView("welcome","p",plist);
			
		}
	
		else
		{      
			
			return new ModelAndView("signin","msg","Plz Re-Enter Credential");
		}
		
		
		
	}
	
	@RequestMapping ("/Show")
	public ModelAndView Show() {	
		
		List<UserLogin> plist=myService.getAllData();
		return new ModelAndView("welcome","p",plist);
	}

	
	
	@RequestMapping("delete/{id}")	
	public ModelAndView deletePlant(@PathVariable("id") int id)
	{
		myService.deletePlantById(id);
		return new ModelAndView("redirect:/Show");	
	}
	
	
	/* For Edit form data show to create Object and send to thje edit form.jsp page*/
	@RequestMapping("edit/{id}")
	public ModelAndView editPlant(@PathVariable("id") int id)
	{
		UserLogin OR = myService.dataDetails(id); 
		return new ModelAndView("editform","OR",OR);
		
	}
	
	@RequestMapping("edit/updatedata/{id}")
	public ModelAndView updatePlant(@RequestParam("id") int id,@RequestParam("fname")String fname,@RequestParam ("lname") String lname,@RequestParam("username")String username,@RequestParam ("password") String password,@RequestParam("dob")String dob,@RequestParam ("address") String address)
	{
		myService.editById(id,fname,lname,username,password,dob,address);
			return new ModelAndView("redirect:/Show");
	}
	
	
	
	
	
	
	
	
	
	
}
