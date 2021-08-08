package com.training.beans;

public class UserLogin 
{
	private int id;
	private String fname;
	private String lname;
	private String username;
	private String password;
	private String dob;
	private String gender;
	private String address;
	public UserLogin() {
		super();
	}
	public UserLogin(int id, String fname, String lname, String username, String password, String dob, String gender,
			String address) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "UserLogin [id=" + id + ", fname=" + fname + ", lname=" + lname + ", username=" + username
				+ ", password=" + password + ", dob=" + dob + ", gender=" + gender + ", address=" + address + "]";
	}
	
}
