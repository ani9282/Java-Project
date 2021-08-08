package com.training.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.beans.AssignTask;
import com.training.beans.ClientDocument;
import com.training.beans.ClientLogin;
import com.training.beans.DisplayBankDocument;
import com.training.beans.EmpLogin;
import com.training.beans.UserLogin;
import com.training.service.MyService;
@Controller
public class EmployeeController {
	
	@Autowired
	private MyService myService;
	
	@RequestMapping ("/employee")
	public ModelAndView employee() {	
		
		return new ModelAndView("emplogin");
	}
	
	@RequestMapping ("/dashboard")
	public ModelAndView employee_dashboard(HttpSession session) {	
		Object v = session.getAttribute ("empname");
		if (v != null && v.equals (1)){
			return new ModelAndView("empDashboard");
		}
		
		else {
			return new ModelAndView("redirect:/");	
		}
		
		
		
	}
	
	
	@RequestMapping ("/displaybankdocument")
	public ModelAndView displaybankdocument(HttpSession hs) {	
		
		String uname = (String) hs.getAttribute("empname");
		if (!hs.isNew() && uname != null) {
			List<DisplayBankDocument> p=myService.displaybankdocument();
			return new ModelAndView("displaybankdocument","p",p);
		}
		else {
			return new ModelAndView("redirect:/");	
		}
		
			
				
	}
	
	
	
	
	
	@RequestMapping ("/employeeregistration")
	public ModelAndView admin(HttpSession hs) {	
		String uname = (String) hs.getAttribute("username");
		if (!hs.isNew() && uname != null) {
			return new ModelAndView("empreg");
		}
		else {
			return new ModelAndView("redirect:/");	
		}
		
	}
	
	
	@RequestMapping ("/displaytask")
	public ModelAndView displaytask(HttpSession hs) {	
		String uname = (String) hs.getAttribute("empname");
		if (!hs.isNew() && uname != null) {
			String name=(String)hs.getAttribute("empname");
			String ename=null;
			//return new ModelAndView("empDashboard");
			List<EmpLogin> empname=myService.getemployeenameforattendence(name);
			EmpLogin c=new EmpLogin();
			ename=empname.get(0).getName();
			List<AssignTask> plist=myService.displaytasktoemployee(ename);
			return new ModelAndView("displaytasktoemployee","plist",plist);
		}
		else {
			return new ModelAndView("redirect:/");	
		}
		
		
		
	}
	
	@RequestMapping ("/displaydocument")
	public ModelAndView displaydocument(HttpSession hs) {	
		String uname = (String) hs.getAttribute("empname");
		if (!hs.isNew() && uname != null) {
			List<ClientDocument> p=myService.displaydocument();
			return new ModelAndView("displaydocumentpage","p",p);
		}
		else {
			return new ModelAndView("redirect:/");	
		}
		
		
		
	}
	
	
	
	
	
	@RequestMapping ("/displayusername")
	public ModelAndView displaydispalyusername(HttpSession hs) {	
		String uname = (String) hs.getAttribute("empname");
		if (!hs.isNew() && uname != null) {
			//List<EmpLogin> addItem=myService.getdispalyusernameAllData();
		    List<ClientLogin> addItem=myService.getdispalyclientname();
			return new ModelAndView("displayusername","addItem",addItem);
		}
		else {
			return new ModelAndView("redirect:/");	
		}
		
		
		
	}
	
	
	
	@RequestMapping ("/clientshow")
	public ModelAndView clientshow(HttpSession hs) {
		String uname = (String) hs.getAttribute("empname");
		if (!hs.isNew() && uname != null) {
			List<ClientLogin> plist=myService.getclientAllData();
			return new ModelAndView("clientshowdata","p",plist);
		}
		else {
			return new ModelAndView("redirect:/");	
		}
		
		
			
	}
	
	
	@RequestMapping ("/updatetaskstatus")
	public ModelAndView updatetaskstatusbyemployee(HttpSession hs) {
		String uname = (String) hs.getAttribute("empname");
		if (!hs.isNew() && uname != null) {
			List<ClientLogin> plist=myService.getclientAllData();
			return new ModelAndView("clientshowdata","p",plist);
		}
		else {
			return new ModelAndView("redirect:/");	
		}
		
		
			
	}
	
	
	
	@RequestMapping("status/{id}")
	public ModelAndView editPlant(HttpSession hs,@PathVariable("id") int id)
	{
		String uname = (String) hs.getAttribute("empname");
		if (!hs.isNew() && uname != null) {
			 myService.editclientstatus(id); 
			 return new ModelAndView("redirect:/clientshow");
			//return new ModelAndView("updatetaskfromemployee");
		}
		else {
			return new ModelAndView("redirect:/");	
		}
		
		
		
	}
	
	
	
	
	
	
	@RequestMapping("/empregister")
	public  ModelAndView userregistration(HttpSession hs,@RequestParam("username") String username, @RequestParam("add") String address,@RequestParam("mobile") String mobile,@RequestParam("email") String email,@RequestParam("password") String password,@RequestParam("cpassword") String cpassword,@RequestParam("dob") String dob,@RequestParam("position") String position)
	{
		
		String uname = (String) hs.getAttribute("username");
		if (!hs.isNew() && uname != null) {
			if(password.equals(cpassword))
			{
				
				myService.employeeregistration(username,address,mobile,email,password,cpassword,dob,position);
				return new ModelAndView("empreg","msg","User Registration successfully Thank You!!!"); 
			}
			
			else {
				return new ModelAndView("empreg","msg","Password not matched"); 
			}
			
		}
		else {
			return new ModelAndView("redirect:/");
		}
		
		
		
		
		
	}
	
	
	@RequestMapping("/employeelogin")
	public ModelAndView empLogin(HttpSession session,@RequestParam(value="username",defaultValue = "10") String username,@RequestParam(value="password",defaultValue = "10") String password)
	{
			
			
	
			boolean ans=myService.empLogin(username,password);
			if(ans)
			{
				session.setAttribute("empname", username);
				String uname=(String)session.getAttribute("empname");
				String ename=null;
				//return new ModelAndView("empDashboard");
				List<EmpLogin> empname=myService.getemployeenameforattendence(uname);
				EmpLogin c=new EmpLogin();
				ename=empname.get(0).getName();
				List<AssignTask> plist=myService.displaytasktoemployee(ename);
				return new ModelAndView("displaytasktoemployee","plist",plist);
				
			}
		
			else
			{      
				if(username.equals("10") && password.equals("10"))
				{
					return new ModelAndView("redirect:/");
				}
				
				else {
					return new ModelAndView("emplogin","msg","Plz Re-Enter Credential");
				}
				
			}
		
			
			
	}
	
	
	@RequestMapping("/emplogout")	
	public ModelAndView Logout(HttpSession sess,HttpServletRequest req)
	{
		sess.invalidate();
		//sess.removeAttribute("username");
		System.out.println("session id="+req);
		return new ModelAndView("redirect:/");	
	}
	
	
	
}
