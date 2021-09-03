package com.example.demo.model;

public class User {

	private int id;
	private String address;
	private String email;
	private String name;
	private String telephone;

	public User() {
		super();
	}

	public User(int id, String address, String email, String name, String telephone) {
		super();
		this.id = id;
		this.address = address;
		this.email = email;
		this.name = name;
		this.telephone = telephone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", address=" + address + ", email=" + email + ", name=" + name + ", telephone="
				+ telephone + "]";
	}

}
