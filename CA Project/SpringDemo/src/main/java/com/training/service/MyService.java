package com.training.service;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.training.beans.AssignTask;
import com.training.beans.AttendenceData;
import com.training.beans.ClientDocument;
import com.training.beans.ClientLogin;
import com.training.beans.DisplayBankDocument;
import com.training.beans.DisplayClientAllData;
import com.training.beans.EmpLogin;
import com.training.beans.UserLogin;


public interface MyService {

	void userregistration(String fname, String lname,String username,String password, String dob, String address);


	boolean login(String username, String password);


	List<UserLogin> getAllData();


	void deletePlantById(int id);


	void editById(int id,String fname, String lname, String username, String password, String dob, String address);


	UserLogin dataDetails(int id);


	boolean adminLogin(String username, String password);


	void employeeregistration(String username, String address, String mobile, String email, String password,
			String cpassword, String dob,String position);


	boolean empLogin(String username, String password);


	void clientregistration(String name, String address, String mobile, String password, String dob, String firm_name,
			String pan_card_number, String firm_type);


	boolean clientLogin(String username, String password);


	List<ClientLogin> getclientAllData();


	void editclientstatus(int id);


	List<EmpLogin> getemployeeData();


	void assigntasktoemployee(String name, String date, String time, String task);


	List<AssignTask> getassignAllData();


	void clientdocument(String name, String filename, String filename1, String filename2);


	List<EmpLogin> getdispalyusernameAllData();


	List<ClientDocument> displaydocument();


	void assigntasktoemployee(int id);


	List<EmpLogin> getemployeenameforattendence();


	void saveassigntasktoemployee(String name, String date, String attendence);


	List<AttendenceData> datewiseattendence(String name, String fromdate, String todate);


  String connectionEstablishementInstamojo(String name,String mobile);


List<ClientLogin> getpaymentname(String mobile);


void savebankdetails(String panno, String name, String accountno, String accountype, String ifsc, String bankname,
		String branchname, String mobile, MultipartFile files)throws IOException;


List<ClientLogin> getdispalyclientname();


void inserimageRecords(String username,MultipartFile file, MultipartFile file1, MultipartFile file2) throws IOException;


Blob showadharcard(int id);


Blob showpancard(int id);


Blob showvoterid(int id);


List<DisplayBankDocument> displaybankdocument();


Blob showallbankdetails(int id);


List<DisplayClientAllData> getemployeedashboarddata(String username);


List<AssignTask> displaytasktoemployee(String uname);


List<EmpLogin> getemployeenameforattendence(String uname);


void updatetaskstatus(int id);










	


	

	
}
