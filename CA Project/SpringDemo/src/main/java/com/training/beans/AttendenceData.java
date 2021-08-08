package com.training.beans;

public class AttendenceData {

	private int id;
	private String name;
	private String date;
	private String attendence;
	
	public AttendenceData() {
		super();
	}

	public AttendenceData(int id, String name, String date, String attendence) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.attendence = attendence;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAttendence() {
		return attendence;
	}

	public void setAttendence(String attendence) {
		this.attendence = attendence;
	}

	@Override
	public String toString() {
		return "AttendenceData [id=" + id + ", name=" + name + ", date=" + date + ", attendence=" + attendence + "]";
	}
	
	
	
	
	
}
