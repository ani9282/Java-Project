package com.training.beans;

public class ClientLogin {

	private int id;
	private String name;
	private String address;
	private String mobile;
	private String password;
	private String cpassword;
	private String dob;
	private String firm_name;
	private String pancard_number;
	private String firm_type;
	
	public ClientLogin() {
		super();
	}

	public ClientLogin(int id, String name, String address, String mobile, String password, String cpassword,
			String dob, String firm_name, String pancard_number, String firm_type) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.mobile = mobile;
		this.password = password;
		this.cpassword = cpassword;
		this.dob = dob;
		this.firm_name = firm_name;
		this.pancard_number = pancard_number;
		this.firm_type = firm_type;
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

	public String getFirm_name() {
		return firm_name;
	}

	public void setFirm_name(String firm_name) {
		this.firm_name = firm_name;
	}

	public String getPancard_number() {
		return pancard_number;
	}

	public void setPancard_number(String pancard_number) {
		this.pancard_number = pancard_number;
	}

	public String getFirm_type() {
		return firm_type;
	}

	public void setFirm_type(String firm_type) {
		this.firm_type = firm_type;
	}

	@Override
	public String toString() {
		return "ClientLogin [id=" + id + ", name=" + name + ", address=" + address + ", mobile=" + mobile
				+ ", password=" + password + ", cpassword=" + cpassword + ", dob=" + dob + ", firm_name=" + firm_name
				+ ", pancard_number=" + pancard_number + ", firm_type=" + firm_type + "]";
	}
	
	
	
}
