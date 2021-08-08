package com.training.service;




import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.training.beans.AssignTask;
import com.training.beans.AttendenceData;
import com.training.beans.ClientDocument;
import com.training.beans.ClientLogin;
import com.training.beans.DisplayBankDocument;
import com.training.beans.DisplayClientAllData;
import com.training.beans.EmpLogin;
import com.training.beans.UserLogin;

import com.training.dao.MyDao;

@Service
public class MyServiceImpl implements MyService
{

	@Autowired
	private MyDao myDao;
	
	public void userregistration(String fname, String lname, String username,String password,String dob, String address)
	{
		myDao.userregistration(fname,lname,username,password,dob,address);
	}

	public boolean login(String username, String password) {
		
		return myDao.login(username,password);
	}

	public List<UserLogin> getAllData() 
	{
		return myDao.getAllData();
	}

	public void deletePlantById(int id)
	{
		myDao.deletePlantById(id);
	}

	public void editById(int id,String fname, String lname, String username, String password, String dob, String address) 
	{
		myDao.editById(id,fname,lname,username,password,dob,address);
		
	}

	public UserLogin dataDetails(int id)
	{
		
		return myDao.dataDetails(id);
	}

	public boolean adminLogin(String username, String password) {
		// TODO Auto-generated method stub
		return myDao.adminLogin(username,password);
	}

	public void employeeregistration(String username, String address, String mobile, String email, String password,
			String cpassword, String dob,String position) {
		// TODO Auto-generated method stub
		myDao.employeeregistration(username,address,mobile,email,password,cpassword,dob,position);
	}

	public boolean empLogin(String username, String password) {
		return myDao.emplogin(username,password);
	}

	public void clientregistration(String name, String address, String mobile, String password, String dob,
			String firm_name, String pan_card_number, String firm_type) {
		myDao.clientregistration(name,address,mobile,password,dob,firm_name,pan_card_number,firm_type);
	}

	public boolean clientLogin(String username, String password) {
		return myDao.clientLogin(username,password);
	
	}

	public List<ClientLogin> getclientAllData() {
		return myDao.getclientAllData();
	}

	public void editclientstatus(int id) {
		myDao.editclientstatus(id);
	}

	public List<EmpLogin> getemployeeData() {
		return myDao.getemployeeData();
	}

	public void assigntasktoemployee(String name, String date, String time, String task) {
		myDao.assigntasktoemployee(name,date,time,task);
		
	}

	public List<AssignTask> getassignAllData() {
		return myDao.getassignAllData();
	}

	public void clientdocument(String name, String filename, String filename1, String filename2) {
		myDao.clientdocument(name,filename,filename1,filename2);
		
	}

	public List<EmpLogin>  getdispalyusernameAllData() {
		return myDao. getdispalyusernameAllData();
	}

	public List<ClientDocument> displaydocument() {
		return myDao.displaydocument();
	}

	public void assigntasktoemployee(int id) {
		myDao.assigntasktoemployee(id);
	}

	public List<EmpLogin> getemployeenameforattendence() {
		return myDao.getemployeenameforattendence();
	}

	public void saveassigntasktoemployee(String name, String date, String attendence) {
		myDao.saveassigntasktoemployee(name,date,attendence);
	}

	public List<AttendenceData> datewiseattendence(String name, String fromdate, String todate) {
		return myDao.datewiseattendence(name,fromdate,todate);
	}

	public String connectionEstablishementInstamojo(String name,String mobile) {
		return myDao.connectionEstablishementInstamojo(name,mobile);
		
	}

	public List<ClientLogin> getpaymentname(String mobile) {
		return myDao.getpaymentname(mobile);
	}

	public void savebankdetails(String panno, String name, String accountno, String accountype, String ifsc,
			String bankname, String branchname, String mobile, MultipartFile files) throws IOException {
		myDao.savebankdetails(panno,name,accountno,accountype,ifsc,bankname,branchname,mobile,files);
	}

	public List<ClientLogin> getdispalyclientname() {
		return myDao.getdispalyclientname();
	}

	public void inserimageRecords(String username,MultipartFile file, MultipartFile file1, MultipartFile file2)  throws IOException{
		myDao. inserimageRecords(username,file, file1,file2);
	}

	public Blob showadharcard(int id) {
	 return myDao.showadharcard(id);
		
	}

	public Blob showpancard(int id) {
		return myDao.showpancard(id);
	}

	public Blob showvoterid(int id) {
		return myDao.showvoterid(id);
	}

	public List<DisplayBankDocument> displaybankdocument() {
		return myDao.displaybankdocument();
	}

	public Blob showallbankdetails(int id) {
		
		return myDao.showallbankdetails(id);
	}

	public List<DisplayClientAllData> getemployeedashboarddata(String username) {
		return myDao.getemployeedashboarddata(username);
	}

	public List<AssignTask> displaytasktoemployee(String uname) {
		
		return myDao.displaytasktoemployee(uname);
	}

	public List<EmpLogin> getemployeenameforattendence(String uname) {
		return myDao.getemployeenameforattendence(uname);
	}

	public void updatetaskstatus(int id) {
		myDao.updatetaskstatus(id);
		
	}

	
	
	

	
	

	

	

	

	
	

	

}
