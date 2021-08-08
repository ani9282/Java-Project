package com.training.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.beans.AssignTask;
import com.training.beans.AttendenceData;
import com.training.beans.EmpLogin;
import com.training.beans.UserLogin;
import com.training.service.MyService;
@Controller
public class AdminController {
	
	@Autowired
	private MyService myService;
	
	
	
	@RequestMapping ("/admin")
	public ModelAndView admin() {	
		return new ModelAndView("adminLogin");
	}
	
	
	@RequestMapping ("/assigntask")
	public ModelAndView assigntask(HttpSession hs) {	
		
		String uname = (String) hs.getAttribute("username");
		if (!hs.isNew() && uname != null) {
			List<EmpLogin> addItem=myService.getemployeeData();
			return new ModelAndView("assigntaskpage","addItem",addItem);
		} else {
			return new ModelAndView("redirect:/");
		}
		
	}
	
	
	@RequestMapping ("/asigntasktoemployee")
	public ModelAndView assigntasktoemployee(HttpSession hs,@RequestParam("name") String name,@RequestParam("date") String date,@RequestParam("time") String time,@RequestParam("task") String task) {
		String uname = (String) hs.getAttribute("username");
		if (!hs.isNew() && uname != null) {
			myService.assigntasktoemployee(name,date,time,task);
			return new ModelAndView("assigntaskpage");
		}
		else {
			return new ModelAndView("redirect:/");
		}
		
	}
	
	
	
	@RequestMapping ("/showalltaskdetail")
	public ModelAndView showalltaskdetail(HttpSession hs,@PathVariable("id") int id) {
		String uname = (String) hs.getAttribute("username");
		if (!hs.isNew() && uname != null) {
			myService.assigntasktoemployee(id);
			return new ModelAndView("assigntaskdetail");
		}
		else {
			return new ModelAndView("redirect:/");
		}
		
	}
	
	
	

	
	
	
	@RequestMapping ("completetask/{id}")
	public ModelAndView taskstatus(HttpSession hs,@PathVariable("id") int id) {
		String uname = (String) hs.getAttribute("username");
		if (!hs.isNew() && uname != null) {
			myService.updatetaskstatus(id);
			return new ModelAndView("assigntaskpage");
		}
		else {
			return new ModelAndView("redirect:/");
		}
		
	}
	
	
	/*
	@RequestMapping ("completetask/{id}")
	public ModelAndView updatetask(HttpSession hs) {
		String uname = (String) hs.getAttribute("username");
		if (!hs.isNew() && uname != null) {
			//myService.updatetaskstatus(id,taskstatus);
			return new ModelAndView("showalltaskdetgailpage");
		}
		else {
			return new ModelAndView("redirect:/");
		}
		
	}

*/
	

	
	
	@RequestMapping("/adminLogin")
	public ModelAndView adminLogin(HttpSession session,@RequestParam(value="username",defaultValue = "10") String username,@RequestParam(value="password",defaultValue = "10") String password)
	{
			
				
			boolean ans=myService.adminLogin(username,password);
			if(ans)
			{
				
					session.setAttribute("username", username);
					String uname=(String)session.getAttribute("username");
					List<AssignTask> plist=myService.getassignAllData();
					return new ModelAndView("adminDashboard","p",plist);		
						//return new ModelAndView("adminDashboard");
					
					
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
	
	
	
	@RequestMapping ("/attendenceemployee")
	public ModelAndView attendenceemployee(HttpSession hs) {	
		String uname = (String) hs.getAttribute("username");
		if (!hs.isNew() && uname != null) {
			List<EmpLogin> addItem=myService.getemployeenameforattendence();
			return new ModelAndView("attendenceemployee","addItem",addItem);
		}
		else {
			return new ModelAndView("redirect:/");
		}
		
		
	}
	
	
	@RequestMapping ("/saveattendenceofemployee")
	public ModelAndView saveattendenceemployee(HttpSession session,@RequestParam(value="name") String name,@RequestParam(value="date") String date,@RequestParam(value="attendence") String attendence) {	
		myService.saveassigntasktoemployee(name,date,attendence);
		return new ModelAndView("redirect:/attendenceemployee");
	}
	
	
	@RequestMapping ("/datewiseattendence")
	public ModelAndView datewiseattendence(HttpSession session,@RequestParam(value="name") String name,@RequestParam(value="fromdate") String fromdate,@RequestParam(value="todate") String todate) {	
		List<AttendenceData> addItem=myService.datewiseattendence(name,fromdate,todate);
		return new ModelAndView("datewiseattendence","addItem",addItem);
	}
	
	@RequestMapping ("/selectdateforattendence")
	public ModelAndView selectdateforattendence(HttpSession hs) {	
		
		String uname = (String) hs.getAttribute("username");
		if (!hs.isNew() && uname != null) {
			List<EmpLogin> addItem=myService.getemployeenameforattendence();
			return new ModelAndView("selectdateforattendence","addItem",addItem);
		}
		else {
			return new ModelAndView("redirect:/");
		}
		
		
		
	}
	
	
	@RequestMapping("/adminlogout")	
	public ModelAndView Logout(HttpSession sess)
	{
		sess.invalidate();
		return new ModelAndView("redirect:/");	
	}
	
	
	
	
}
