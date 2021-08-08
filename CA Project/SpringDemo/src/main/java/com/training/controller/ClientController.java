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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.training.beans.AssignTask;
import com.training.beans.ClientDocument;
import com.training.beans.ClientLogin;
import com.training.beans.DisplayClientAllData;
import com.training.beans.EmpLogin;
import com.training.service.MyService;

@Controller
public class ClientController {
	
	@Autowired
	private MyService myService;
	
	
	private static final String UPLOAD_DIRECTORY1 ="resources/document/";
	private static final String UPLOAD_DIRECTORY ="resources/images/";
	// String UPLOAD_DIRECTORY = getClass().getResource("/resource/document").toString();
   // System.out.println(fullPath);
	@RequestMapping ("/client")
	public ModelAndView client() {	
		return new ModelAndView("clientLogin");
	}
	
	
	@RequestMapping ("/clientregistration")
	public ModelAndView clientregistration() {	
		return new ModelAndView("clientreg");
	}
	
	
	

	
	@RequestMapping ("/uploaddetails")
	public ModelAndView uploaddetails(HttpSession hs) {	
		String uname = (String) hs.getAttribute("clientname");
		if (!hs.isNew() && uname != null) {
			return new ModelAndView("uploaddetailpage");
		}
		else {
			return new ModelAndView("redirect:/");	
		}
		
		
	}
	
	
	@RequestMapping ("/clientreg")
	public  ModelAndView clientregistration(HttpSession hs,@RequestParam("name") String name, @RequestParam("address") String address,@RequestParam("mobile") String mobile,@RequestParam("password") String password,@RequestParam("cpassword") String cpassword,@RequestParam("dob") String dob,@RequestParam("firm_name") String firm_name,@RequestParam("pan_card_number") String pan_card_number,@RequestParam("firm_type") String firm_type)
	{
		
			if(password.equals(cpassword))
			{
				myService.clientregistration(name,address,mobile,password,dob,firm_name,pan_card_number,firm_type);
				return new ModelAndView("clientLogin","msg","Client Registration successfully Thank You!!!"); 
			}
			
			else {
				return new ModelAndView("clientreg","msg","Password not matched"); 
			}
		
		
		
		
		
	}
	
	
	@RequestMapping("/clientlogin")
	public ModelAndView clientLogin(HttpSession session,@RequestParam(value="username",defaultValue = "10") String username,@RequestParam(value="password",defaultValue = "10") String password)
	{
	
		
		boolean ans=myService.clientLogin(username,password);
		if(ans)
		{
			session.setAttribute("clientname",username);
			List<DisplayClientAllData> addItem=myService.getemployeedashboarddata(username);
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("List -----------"+addItem);
			return new ModelAndView("clientDashboard","addItem",addItem);
			
			//return new ModelAndView("clientDashboard");
			
		}
	
		else
		{      
			if(username.equals("10") && password.equals("10"))
			{
				return new ModelAndView("redirect:/");
			}
			
			else {
				return new ModelAndView("clientLogin","msg","Plz Re-Enter Credential");
			}
			
			
			
		}
		
			
	}
	
	
	/*
	 @RequestMapping(value="savefile",method=RequestMethod.POST)  
	    public ModelAndView saveimage(HttpServletRequest req ,@RequestParam CommonsMultipartFile file,  @RequestParam CommonsMultipartFile file1, @RequestParam CommonsMultipartFile file2, 
	           HttpSession session, HttpSession session1, HttpSession session2) throws Exception{  
	  
	    ServletContext context = session.getServletContext();  
	    String path = context.getRealPath(UPLOAD_DIRECTORY);  
	    String filename = file.getOriginalFilename();  
	    System.out.println(path+" "+filename);        
	    
	    byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(path + File.separator +filename)));  
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();
	    
	    //-----------------------------------------------------------------------------------
	    ServletContext context1 = session1.getServletContext();  
	    String path1 = context1.getRealPath(UPLOAD_DIRECTORY);  
	    String filename1 = file1.getOriginalFilename();  
	  
	    System.out.println(path1+" "+filename1);        
	  
	    byte[] bytes1 = file1.getBytes();  
	    BufferedOutputStream stream1 =new BufferedOutputStream(new FileOutputStream(  
	         new File(path + File.separator +filename1)));  
	    stream1.write(bytes1);  
	    stream1.flush();  
	    stream1.close();
	    
	    //---------------------------------------------------------------------
	    ServletContext context2 = session2.getServletContext();  
	    String path2 = context2.getRealPath(UPLOAD_DIRECTORY);  
	    String filename2 = file2.getOriginalFilename();  
	  
	    System.out.println(path2+" "+filename2);        
	  
	    byte[] bytes2 = file2.getBytes();  
	    BufferedOutputStream stream2 =new BufferedOutputStream(new FileOutputStream(  
	         new File(path2 + File.separator +filename2)));  
	    stream2.write(bytes2);  
	    stream2.flush();  
	    stream2.close();
	    
	    String name=req.getSession().getAttribute ("clientname").toString();
	    System.out.println("Username is="+name);
	    
	    
	    myService.clientdocument(name,filename,filename1,filename2);
	    
	    return new ModelAndView("uploaddetailpage","msg","File successfully saved!");  
	    }  
	
	*/
	
	 @RequestMapping(value="savefile",method=RequestMethod.POST) 
	 public ModelAndView saveimage(HttpSession hs,HttpServletRequest req ,@RequestParam MultipartFile file,  @RequestParam MultipartFile file1, @RequestParam MultipartFile file2,HttpSession session, HttpSession session1, HttpSession session2)  throws IOException
	 {
		 String uname = (String) hs.getAttribute("clientname");
			if (!hs.isNew() && uname != null) {
				String name=req.getSession().getAttribute ("clientname").toString();
				 System.out.println("Username is="+name);
				 myService.inserimageRecords(name,file, file1,file2);
				 return new ModelAndView("uploaddetailpage","msg","File successfully saved!");
			}
			else {
				return new ModelAndView("redirect:/");	
			}
			
		 
	 }
	 
	 
	 @RequestMapping(value="savebankdetails",method=RequestMethod.POST)  
	    public ModelAndView savebankdetails(HttpSession hs,HttpServletRequest req,@RequestParam("panno") String panno,@RequestParam("name") String name,@RequestParam("accountno") String accountno,@RequestParam("accountype") String accountype,@RequestParam("ifsc") String ifsc,@RequestParam("bankname") String bankname,@RequestParam("branchname") String branchname,@RequestParam("mobile") String mobile,@RequestParam MultipartFile files) throws Exception{  
	  
		 /*
		ServletContext context = session.getServletContext();  
	    String path = context.getRealPath(UPLOAD_DIRECTORY1);  
	    String filename = file.getOriginalFilename();  
	    System.out.println(path+" "+filename);        
	    
	    byte[] bytes = file.getBytes();  
	    BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
	         new File(path + File.separator + filename)));  
	    stream.write(bytes);  
	    stream.flush();  
	    stream.close();
	   
	    */
		 String uname = (String) hs.getAttribute("clientname");
			if (!hs.isNew() && uname != null) {
				 myService.savebankdetails(panno,name,accountno,accountype,ifsc,bankname,branchname,mobile,files);
				    return new ModelAndView("redirect:/uploadbankdetail");
			}
			else {
				return new ModelAndView("redirect:/");	
			}
		 
		 
	   
	 }
	 
	 
	 
	
	 @RequestMapping("/uploadbankdetail")	
		public ModelAndView  uploadbankdetail(HttpSession hs)
		{
		 String uname = (String) hs.getAttribute("clientname");
			if (!hs.isNew() && uname != null) {
				return new ModelAndView("uploadbankdetailpage");	
			}
			else {
				return new ModelAndView("redirect:/");	
			}
			
		}
	 
	 
	 @RequestMapping("adharcard/{id}")
		public ModelAndView showadharcard(HttpSession hs,HttpServletResponse response,@PathVariable("id") int id) throws IOException, SQLException
		{
		 	
		 String uname = (String) hs.getAttribute("empname");
			if (!hs.isNew() && uname != null) {
				response.setContentType("image/jpeg");
			    Blob ph=myService.showadharcard(id);
			    byte[] bytes = ph.getBytes(1, (int) ph.length());
				InputStream inputStream = new ByteArrayInputStream(bytes);
				IOUtils.copy(inputStream, response.getOutputStream());
				return new ModelAndView("adharcardpage");
			}
			else {
				return new ModelAndView("redirect:/");	
			}
			
			
		 	
			
		}
	 
	 
	 @RequestMapping("pancard/{id}")
		public ModelAndView showpancard(HttpSession hs,HttpServletResponse response,@PathVariable("id") int id) throws IOException, SQLException
		{
		 
		 String uname = (String) hs.getAttribute("empname");
			if (!hs.isNew() && uname != null) {
				response.setContentType("image/jpeg");
			    Blob ph=myService.showpancard(id);
			    byte[] bytes = ph.getBytes(1, (int) ph.length());
				InputStream inputStream = new ByteArrayInputStream(bytes);
				IOUtils.copy(inputStream, response.getOutputStream());
				return new ModelAndView("pancardpage");
			}
			else {
				return new ModelAndView("redirect:/");	
			}
			
			
		 	
			
		}
	 
	 
	 @RequestMapping("voterid/{id}")
		public ModelAndView showvoterid(HttpSession hs,HttpServletResponse response,@PathVariable("id") int id) throws IOException, SQLException
		{
		 
		 String uname = (String) hs.getAttribute("empname");
			if (!hs.isNew() && uname != null) {
				response.setContentType("image/jpeg");
			    Blob ph=myService.showvoterid(id);
			    byte[] bytes = ph.getBytes(1, (int) ph.length());
				InputStream inputStream = new ByteArrayInputStream(bytes);
				IOUtils.copy(inputStream, response.getOutputStream());
				return new ModelAndView("voteridpage");
			}
			else {
				return new ModelAndView("redirect:/");	
			}
			
		 	
			
		}
	 
	 
	
	 @RequestMapping("showpdf/{id}")
		public ModelAndView showallbankdetails(HttpSession hs,HttpServletResponse res,@PathVariable("id") int id) throws IOException, SQLException
		{
		 String uname = (String) hs.getAttribute("empname");
			if (!hs.isNew() && uname != null) {
				res.setContentType("application/pdf");
				res.getOutputStream().flush();
			    Blob ph=myService.showallbankdetails(id);
			    //byte[] bytes = ph.getBytes(1, (int) ph.length());
			    InputStream is = ph.getBinaryStream();
				IOUtils.copy(is,res.getOutputStream());
				 
				return new ModelAndView("showpdfpage");
			}
			else {
				return new ModelAndView("redirect:/");	
			}
			
		}
	 
	 

	
	 
	 @RequestMapping("/clientlogout")	
		public ModelAndView Logout(HttpSession sess,HttpServletRequest req)
		{
			sess.invalidate();
			req.getSession().invalidate();
			//sess.removeAttribute("username");
			System.out.println("session id="+req);
			return new ModelAndView("redirect:/");	
		}
	
	
	
	 @RequestMapping ("/makepayment")
		public ModelAndView makepayment(HttpSession session) {
		String mobile=session.getAttribute("clientname").toString();
		 //String name=(String)hs.getAttribute("clientname");
		// System.out.println("name of user="+name);
		String name = null;
		List<ClientLogin> plist=myService.getpaymentname(mobile);
		
		    ClientLogin c=new ClientLogin();
		    name=plist.get(0).getName();
		System.out.println("name="+name);
		 String url=myService.connectionEstablishementInstamojo(name,mobile);
		 System.out.println("url in controller="+url);
		return new ModelAndView("redirect:"+url);
		
		
		}
	 
	 
	

}
