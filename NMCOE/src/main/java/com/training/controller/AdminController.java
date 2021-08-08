package com.training.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.beans.DisplayDevice;
import com.training.service.MyService;

@Controller
public class AdminController {

	
	@Autowired
	private MyService myService;
	
	@RequestMapping ("/admin")
	public ModelAndView admin() {	
		return new ModelAndView("adminLogin");
	}
	
	
	@RequestMapping("/adminLogin")
	public ModelAndView adminLogin(HttpSession session,@RequestParam(value="username",defaultValue = "10") String username,@RequestParam(value="password",defaultValue = "10") String password)
	{
	
		
		boolean ans=myService.adminLogin(username,password);
		if(ans)
		{
			session.setAttribute("username",username);
			String uname=(String)session.getAttribute("username");
			
			return new ModelAndView("adminDashboard");
			
		}
	
		else
		{      
			
			if(username.equals("10") && password.equals("10"))
			{
				return new ModelAndView("redirect:/");
			}
			
			else {
				return new ModelAndView("adminLogin","msg","Plz Re-Enter Credential");
			}
			
		}
		
		
		
	}
	
	
	@RequestMapping ("/deviceregistration")
	public ModelAndView deviceregistration(HttpSession hs) {	
		String uname = (String) hs.getAttribute("username");
		if (!hs.isNew() && uname != null) {
			return new ModelAndView("devicename");
		}
		else {
			return new ModelAndView("redirect:/");
		}
		
	}
	
	
	@RequestMapping ("/savedevicename")
	public ModelAndView savedevicename(HttpSession hs,@RequestParam("name") String name) {	
		String uname = (String) hs.getAttribute("name");
		if (!hs.isNew() && uname != null) {

			myService.savedevicename(name);
			return new ModelAndView("redirect:/devicename");
		}
		else {
			return new ModelAndView("redirect:/");
		}
		
	}
	
	
	@RequestMapping ("/displaydevice")
	public ModelAndView displaydevice(HttpSession hs) {	
		
		String uname = (String) hs.getAttribute("username");
		if (!hs.isNew() && uname != null) {

			List<DisplayDevice> plist=myService.displaydevice();
			return new ModelAndView("displayname","plist",plist);
		}
		else {
			return new ModelAndView("redirect:/");
		}
		

	}
	
	
	@RequestMapping ("/adminlogout")
	public ModelAndView adminlogout(HttpSession sess) {	
		sess.invalidate();
		return new ModelAndView("redirect:/");

	}
	
	
}
