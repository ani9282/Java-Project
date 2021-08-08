package com.training.dao;

import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.instamojo.wrapper.api.Instamojo;
import com.instamojo.wrapper.api.InstamojoImpl;
import com.instamojo.wrapper.exception.ConnectionException;
import com.instamojo.wrapper.exception.InvalidPaymentOrderException;
import com.instamojo.wrapper.model.PaymentOrder;
import com.instamojo.wrapper.response.CreatePaymentOrderResponse;
import com.instamojo.wrapper.response.Response;
import com.training.beans.AssignTask;
import com.training.beans.AttendenceData;
import com.training.beans.ClientDocument;
import com.training.beans.ClientLogin;
import com.training.beans.DisplayBankDocument;
import com.training.beans.DisplayClientAllData;
import com.training.beans.EmpLogin;
import com.training.beans.UserLogin;


@Repository
public class MyDaoImpl implements MyDao
{

	@Autowired
	private JdbcTemplate jdbc;

	public void userregistration(String fname, String lname, String username, String password, String dob,
			String address) 
	{
		String sql="insert into registration(fname,lname,username,password,dob,address) values(?,?,?,?,?,?)";
	     jdbc.update(sql,new Object[] {fname,lname,username,password,dob,address});	
		
	}

	

	
	
public Boolean login(String username, String password)
{
	try {
		
		
		String sql="select * from registration where username=? and password=?";
		UserLogin a=jdbc.queryForObject(sql, new Object[] {username,password},new RowMapper<UserLogin>() {
			
		
			public UserLogin mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserLogin a=new UserLogin();
				a.setUsername(rs.getString(4));
				a.setPassword(rs.getString(5));
				return a;
				
			}});
		if(a.getUsername().equals(username) && a.getPassword().equals(password)) 
		{
			return true;
		}
		else 
		{
			return false;
		}
		
	   }
		catch(Exception e)
		{
			return false;
				
		}

}





public List<UserLogin> getAllData() 
{
	String sql="select * from registration";
	List<UserLogin> plist=jdbc.query(sql, new RowMapper<UserLogin>()
	{	
		public UserLogin mapRow(ResultSet rs,int nrows) throws SQLException
		{
			UserLogin p=new UserLogin();
			p.setId(rs.getInt(1));
			p.setFname(rs.getString(2));
			p.setLname(rs.getString(3));
			p.setUsername(rs.getString(4));
			p.setPassword(rs.getString(5));
			p.setDob(rs.getString(6));
			p.setAddress(rs.getString(7));
			return p;
		
		}});
	return plist;
}





public void deletePlantById(int id)
{
	String sql="delete from registration where id=?";
	jdbc.update(sql,new Object[] {id});
	
}





public void editById(int id,String fname, String lname, String username, String password, String dob, String address) 
{
	String sql="update registration set fname=?,lname=?,username=?,password=?,dob=?,address=? where id=?";
	jdbc.update(sql,new Object[] {fname,lname,username,password,dob,address,id});
}





public UserLogin dataDetails(int id)
{
	String sql="select * from registration where id=?";
	return jdbc.queryForObject(sql,new Object[] {id},new RowMapper<UserLogin>()
	{

		public UserLogin mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			
			UserLogin b= new UserLogin();
			
			b.setId(rs.getInt(1));
			b.setFname(rs.getString(2));
			b.setLname(rs.getString(3));
			b.setUsername(rs.getString(4));
			b.setPassword(rs.getString(5));
			b.setDob(rs.getString(6));
			b.setAddress(rs.getString(7));
		
			
			
			return b;
		}
		
	});
}





public Boolean adminLogin(String username, String password) {
	// TODO Auto-generated method stub
	if(username.equals("admin") && password.equals("admin")) 
	{
		return true;
	}
	else 
	{
		return false;
	}
	
}





public void employeeregistration(String username, String address, String mobile, String email, String password,
		String cpassword,String dob,String position) {
	

		String sql="insert into empregistration(username,address,mobile,email,password,dob,position) values(?,?,?,?,?,?,?)";
	    jdbc.update(sql,new Object[] {username,address,mobile,email,password,dob,position});	
	
}





public boolean emplogin(String username, String password) {
	try {
		String sql="select * from empregistration where mobile=? and password=?";
		EmpLogin a=jdbc.queryForObject(sql, new Object[] {username,password},new RowMapper<EmpLogin>() {
			
		
			public EmpLogin mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmpLogin a=new EmpLogin();
				a.setMobile(rs.getString(4));
				a.setPassword(rs.getString(6));
				return a;
				
			}});
		if(a.getMobile().equals(username) && a.getPassword().equals(password)) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	   }
		catch(Exception e)
		{
			return false;
		}
}





public void clientregistration(String name, String address, String mobile, String password, String dob,
		String firm_name, String pan_card_number, String firm_type) {
	String status="Block";
	String sql="insert into clientregistration(name,address,mobile,password,dob,firm_name,pancard_number,firm_type,status) values(?,?,?,?,?,?,?,?,?)";
    jdbc.update(sql,new Object[] {name,address,mobile,password,dob,firm_name,pan_card_number,firm_type,status});	
	
}





public boolean clientLogin(String username, String password) {
	try {
		String sql="select * from clientregistration where mobile=? and password=?";
		ClientLogin a=jdbc.queryForObject(sql, new Object[] {username,password},new RowMapper<ClientLogin>() {
			
		
			public ClientLogin mapRow(ResultSet rs, int rowNum) throws SQLException {
				ClientLogin a=new ClientLogin();
				a.setMobile(rs.getString(4));
				a.setPassword(rs.getString(5));
				return a;
				
			}});
		if(a.getMobile().equals(username) && a.getPassword().equals(password)) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	   }
		catch(Exception e)
		{
			return false;
		}
}





public List<ClientLogin> getclientAllData() {

	String sql="select * from clientregistration where status='Block'";
	List<ClientLogin> plist=jdbc.query(sql, new RowMapper<ClientLogin>()
	{	
		public ClientLogin mapRow(ResultSet rs,int nrows) throws SQLException
		{
			ClientLogin p=new ClientLogin();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setAddress(rs.getString(3));
			p.setMobile(rs.getString(4));
			p.setPassword(rs.getString(5));
			p.setDob(rs.getString(6));
			p.setFirm_name(rs.getString(7));
			p.setPancard_number(rs.getString(8));
			p.setFirm_type(rs.getString(9));
		
			return p;
		
		}});
	return plist;
}





public void editclientstatus(int id) {
	String sql="update clientregistration set status='Unblock' where id=?";
	jdbc.update(sql,new Object[] {id});
}





public List<EmpLogin> getemployeeData() {
	String sql="select * from empregistration";
	List<EmpLogin> addItem=jdbc.query(sql, new RowMapper<EmpLogin>()
	{	
		public EmpLogin mapRow(ResultSet rs,int nrows) throws SQLException
		{
			EmpLogin p=new EmpLogin();
			p.setName(rs.getString(2));
		
			return p;
		}});
	return addItem;
}





public void assigntasktoemployee(String name, String date, String time, String task) {
	String status="Pending";
	String sql="insert into assign_task(name,date,time,task,status) values(?,?,?,?,?)";
    jdbc.update(sql,new Object[] {name,date,time,task,status});
	
}





public List<AssignTask> getassignAllData() {
	String sql="select * from assign_task";
	List<AssignTask> plist=jdbc.query(sql, new RowMapper<AssignTask>()
	{	
		public AssignTask mapRow(ResultSet rs,int nrows) throws SQLException
		{
			AssignTask p=new AssignTask();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setDate(rs.getString(3));
			p.setTime(rs.getString(4));
			p.setTask(rs.getString(5));
			p.setStatus(rs.getString(6));
			
			return p;
		}});
	return plist;
}





public void clientdocument(String name, String filename, String filename1, String filename2) {
	String sql="insert into clientdocument(username,adharcard,pancard,voterid) values(?,?,?,?)";
    jdbc.update(sql,new Object[] {name,filename,filename1,filename2});	
	
}





public List<EmpLogin> getdispalyusernameAllData() {
	String sql="select * from empregistration";
	List<EmpLogin> addItem=jdbc.query(sql, new RowMapper<EmpLogin>()
	{	
		public EmpLogin mapRow(ResultSet rs,int nrows) throws SQLException
		{
			EmpLogin p=new EmpLogin();
			p.setName(rs.getString(2));
		
			return p;
		}});
	return addItem;
}





public List<ClientDocument> displaydocument() {
	String sql="select * from clientdocument";
	//System.out.println("username="+name);
	List<ClientDocument> plist=jdbc.query(sql, new RowMapper<ClientDocument>()
	{	
		public ClientDocument mapRow(ResultSet rs,int nrows) throws SQLException
		{
			ClientDocument p=new ClientDocument();
			p.setId(rs.getInt(1));
			p.setUsername(rs.getString(2));
			p.setAdharcard(rs.getString(3));
			p.setPancard(rs.getString(4));
			p.setVoterid(rs.getString(5));
			return p;
		}});
	return plist;
}





public void assigntasktoemployee(int id) {
	
}





public List<EmpLogin> getemployeenameforattendence() {
	String sql="select * from empregistration";
	List<EmpLogin> addItem=jdbc.query(sql, new RowMapper<EmpLogin>()
	{	
		public EmpLogin mapRow(ResultSet rs,int nrows) throws SQLException
		{
			EmpLogin p=new EmpLogin();
			p.setName(rs.getString(2));
			return p;
		}});
	return addItem;
}





public void saveassigntasktoemployee(String name, String date, String attendence) {
	String sql="insert into attendence_empoloyee_data(name,date,attendence) values(?,?,?)";
    jdbc.update(sql,new Object[] {name,date,attendence});	
}





public List<AttendenceData> datewiseattendence(String name, String fromdate, String todate) {
	String sql="select * from attendence_empoloyee_data WHERE NAME='"+name+"'and date BETWEEN '"+fromdate+"' AND '"+todate+"' order by date";
	List<AttendenceData> plist=jdbc.query(sql, new RowMapper<AttendenceData>()
	{	
		public AttendenceData mapRow(ResultSet rs,int nrows) throws SQLException
		{
			AttendenceData p=new AttendenceData();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));;
			p.setDate(rs.getString(3));;
			p.setAttendence(rs.getString(4));;
			
			return p;
		}});
	return plist;
}





public String connectionEstablishementInstamojo(String name,String mobile) {
	String url = null;
	String clientId = "QxEmlJaM2ke0BQAP1x14oIaDcp2jz7Gj1yjecOSE";
    String clientSecret = "7N1wLVo4pNtLWIpeFeKvwB2QeXq51TskOOwwe2ko0lJQzZiwB53rb4HxLyEdUeTULJifmrIb3xeSL137RPmPH7hy0Lo12RyddKV2QGDofTXgpTbEFY6JMYBrT7LpPjvh";
    String apiEndPoint = "https://api.instamojo.com/v2/";
    String authEndPoint = "https://www.instamojo.com/oauth2/token/";
    try {
        // gets the reference to the instamojo api
        Instamojo api = InstamojoImpl.getApi(clientId, clientSecret, apiEndPoint, authEndPoint);
        System.out.println("connection successfully done");
        PaymentOrder order = new PaymentOrder();
        CreatePaymentOrderResponse createPaymentOrderResponse = new CreatePaymentOrderResponse();
        order.setName(name);
        order.setEmail("rahulpawar9766@gmail.com");
        order.setPhone(mobile);
        order.setCurrency("INR");
        double amount=15.00;
        order.setAmount(amount);
        order.setDescription("Create New Order");
        order.setRedirectUrl("http://www.ecssofttech.com");
        order.setWebhookUrl("http://www.someurl.com/");
        //Unique Transaction Id Here i used UUID
        order.setTransactionId(UUID.randomUUID().toString());
        //connect to instamojo
       // connectionEstablishementInstamojo();
        boolean isOrderValid = order.validate();
        if (isOrderValid) {
            try {
                createPaymentOrderResponse = api.createNewPaymentOrder(order);
                // print the status of the payment order.         
                
                createPaymentOrderResponse.getPaymentOptions().getPaymentUrl();
                url= createPaymentOrderResponse.getPaymentOptions().getPaymentUrl();
                System.out.println("url"+ createPaymentOrderResponse.getPaymentOptions().getPaymentUrl());
                System.out.println("payment status code"+createPaymentOrderResponse.getPaymentOrder().getStatus());
                
            } catch (InvalidPaymentOrderException e) {
                //logger.log(Level.SEVERE, e.toString(), e);
                if (order.isTransactionIdInvalid()) {
                    System.out.println("Transaction id is invalid. This is mostly due to duplicate  transaction id.");
                }
                if (order.isCurrencyInvalid()) {
                    System.out.println("Currency is invalid.");
                }
            } catch (ConnectionException e) {
                //Logger.log(Level.SEVERE, e.toString(), e);
            }
        } else {
            // inform validation errors to the user.
            if (order.isTransactionIdInvalid()) {
                System.out.println("Transaction id is invalid.");
            }
            if (order.isAmountInvalid()) {
                System.out.println("Amount can not be less than 9.00.");
            }
            if (order.isCurrencyInvalid()) {
                System.out.println("Please provide the currency.");
            }
            if (order.isDescriptionInvalid()) {
                System.out.println("Description can not be greater than 255 characters.");
            }
            if (order.isEmailInvalid()) {
                System.out.println("Please provide valid Email Address.");
            }
            if (order.isNameInvalid()) {
                System.out.println("Name can not be greater than 100 characters.");
            }
            if (order.isPhoneInvalid()) {
                System.out.println("Phone is invalid.");
            }
            if (order.isRedirectUrlInvalid()) {
                System.out.println("Please provide valid Redirect url.");
            }
            if (order.isWebhookInvalid()) {
                System.out.println("Provide a valid webhook url");
            }
        }
        //return createPaymentOrderResponse;
    }catch (ConnectionException e) {
       // LOGGER.log(Level.SEVERE, e.toString(), e);
        System.out.println(e);
    }
    
    return url; 
}





public List<ClientLogin> getpaymentname(String mobile) {
	String sql="select * from clientregistration where mobile='"+mobile+"'";
	List<ClientLogin> plist=jdbc.query(sql, new RowMapper<ClientLogin>()
	{	
		public ClientLogin mapRow(ResultSet rs,int nrows) throws SQLException
		{
			ClientLogin p=new ClientLogin();
			p.setName(rs.getString(2));
			return p;
		}});
	return plist;
}





public void savebankdetails(String panno, String name, String accountno, String accountype, String ifsc,
		String bankname, String branchname, String mobile, MultipartFile files) throws IOException {
	byte[] photoBytes = files.getBytes();
	String sql="insert into clientbankdetails(panno,name,accountno,accounttype,ifsc,bankname,branchname,mobile,files) values(?,?,?,?,?,?,?,?,?)";
    jdbc.update(sql,new Object[] {panno,name,accountno,accountype,ifsc,bankname,branchname,mobile,photoBytes});
}





public List<ClientLogin> getdispalyclientname() {
	String sql="select * from clientregistration";
	List<ClientLogin> plist=jdbc.query(sql, new RowMapper<ClientLogin>()
	{	
		public ClientLogin mapRow(ResultSet rs,int nrows) throws SQLException
		{
			ClientLogin p=new ClientLogin();
			p.setName(rs.getString(2));
			return p;
		
		}});
	return plist;
}





public void inserimageRecords(String username,MultipartFile file, MultipartFile file1, MultipartFile file2) throws IOException {
	byte[] photoBytes = file.getBytes();
	byte[] photoBytes1 = file1.getBytes();
	byte[] photoBytes2 = file2.getBytes();
	String sql = "INSERT INTO clientdocument(username,adharcard,pancard,voterid) VALUES (?,?,?,?)";

	jdbc.update(sql, new Object[] {username,photoBytes,photoBytes1,photoBytes2 });
}





public Blob showadharcard(int id) {
	
	String query = "select adharcard from clientdocument where id=?";

	Blob photo = jdbc.queryForObject(query, new Object[] { id }, Blob.class);
	
	return photo;
}





public Blob showpancard(int id) {
	String query = "select pancard from clientdocument where id=?";

	Blob photo = jdbc.queryForObject(query, new Object[] { id }, Blob.class);
	
	return photo;
}





public Blob showvoterid(int id) {
	String query = "select voterid from clientdocument where id=?";

	Blob photo = jdbc.queryForObject(query, new Object[] { id }, Blob.class);
	
	return photo;
}





public List<DisplayBankDocument> displaybankdocument() {
	String sql="select * from clientbankdetails";
	//System.out.println("username="+name);
	List<DisplayBankDocument> plist=jdbc.query(sql, new RowMapper<DisplayBankDocument>()
	{	
		public DisplayBankDocument mapRow(ResultSet rs,int nrows) throws SQLException
		{
			DisplayBankDocument p=new DisplayBankDocument();
			p.setId(rs.getInt(1));
			p.setPanno(rs.getString(2));
			p.setName(rs.getString(3));
			p.setAccountno(rs.getString(4));
			p.setAccounttype(rs.getString(5));
			p.setIfsc(rs.getString(6));
			p.setBankname(rs.getString(7));
			p.setBranchname(rs.getString(8));
			p.setMobile(rs.getString(9));
			p.setFile(rs.getString(10));
			
			return p;
		}});
	return plist;
}





public Blob showallbankdetails(int id) {
	String query="select files from clientbankdetails where id=?";
	Blob photo=jdbc.queryForObject(query, new Object[]{id},Blob.class);
	return photo;
}





public List<DisplayClientAllData> getemployeedashboarddata(String username) 
{
	
	String name;
	name=username;
	//String sql="select * from clientdocument where username='"+username+"'";
	String sql="SELECT * FROM  clientdocument,clientbankdetails WHERE clientdocument.username='"+username+"' AND clientbankdetails.mobile='"+username+"'";
	List<DisplayClientAllData> plist=jdbc.query(sql, new RowMapper<DisplayClientAllData>()
	{	
		public DisplayClientAllData mapRow(ResultSet rs,int nrows) throws SQLException
		{
			final String status,status1,status2,status3;
			DisplayClientAllData p=new DisplayClientAllData();
			//p.setName(rs.getString(2));
			String e=rs.getString(3).toString();
			if(e == null) {
				status="Adharcard Not Upload";
				} else{
					
					status="Uploaded Adharcard";
				}
			
			String e1=rs.getString(4).toString();
			if(e1 == null) {
				status1="Pancard Not Upload";
				} else{
					
					status1="Uploaded pancard";
				}
			
			String e2=rs.getString(5).toString();
			if(e2 == null) {
				status2="Pancard Not Upload";
				} else{
					
					 status2="Uploaded pancard";
				}
			
			
			p.setPanno(rs.getString("panno"));
			p.setAccountno(rs.getString(9));
			p.setAccounttype(rs.getString(10));
			p.setIfsc(rs.getString(11));
			p.setBankname(rs.getString(12));
			p.setBranchname(rs.getString(13));
			
			String e3=rs.getString(15).toString();
			if(e3 == null) {
				status3="Balance Sheet Not Upload";
				} else{
					
					 status3="Uploaded Balance Sheet";
				}
			p.setAdharcard(status);
			p.setPancard(status1);
			p.setVoterid(status2);
			p.setFile(status3);
			return p;
		
		}});
	return plist;
}





public List<AssignTask> displaytasktoemployee(String uname) {
	String sql="select * from assign_task where name='"+uname+"'";
	List<AssignTask> plist=jdbc.query(sql, new RowMapper<AssignTask>()
	{	
		public AssignTask mapRow(ResultSet rs,int nrows) throws SQLException
		{
			AssignTask p=new AssignTask();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setDate(rs.getString(3));
			p.setTime(rs.getString(4));
			p.setTask(rs.getString(5));
			p.setStatus(rs.getString(6));
			
			return p;
		}});
	return plist;
}





public List<EmpLogin> getemployeenameforattendence(String uname) {
	String sql="select * from empregistration where mobile='"+uname+"'";
	List<EmpLogin> addItem=jdbc.query(sql, new RowMapper<EmpLogin>()
	{	
		public EmpLogin mapRow(ResultSet rs,int nrows) throws SQLException
		{
			EmpLogin p=new EmpLogin();
			p.setName(rs.getString(2));
		
			return p;
		}});
	return addItem;
}





public void updatetaskstatus(int id) {
	String status="Completed";
	String sql="update assign_task set status='Completed' where id=?";
	jdbc.update(sql,new Object[] {id});
	
}

































}

	
	

	

	

