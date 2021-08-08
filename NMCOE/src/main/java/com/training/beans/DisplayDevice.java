package com.training.beans;

public class DisplayDevice {
	private int id;
	private String name;
	
	public DisplayDevice() {
		super();
	}

	public DisplayDevice(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() {
		return "DisplayDevice [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
