package com.training.beans;

public class EmpLogin {

	private int id;
	private String name;
	private String address;
	private String mobile;
	private String email;
	private String password;
	private String cpassword;
	private String dob;
	private String position;
	
	public EmpLogin() {
		super();
	}

	public EmpLogin(int id, String name, String address, String mobile, String email, String password, String cpassword,
			String dob, String position) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.cpassword = cpassword;
		this.dob = dob;
		this.position = position;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "EmpLogin [id=" + id + ", name=" + name + ", address=" + address + ", mobile=" + mobile + ", email="
				+ email + ", password=" + password + ", cpassword=" + cpassword + ", dob=" + dob + ", position="
				+ position + "]";
	}
	
	
}
