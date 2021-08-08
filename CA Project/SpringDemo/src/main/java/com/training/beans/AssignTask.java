package com.training.beans;

public class AssignTask {

	private int id;
	private String name;
	private String date;
	private String time;
	private String task;
	private String status;
	
	public AssignTask() {
		super();
	}

	public AssignTask(int id, String name, String date, String time, String task, String status) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.time = time;
		this.task = task;
		this.status = status;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AssignTask [id=" + id + ", name=" + name + ", date=" + date + ", time=" + time + ", task=" + task
				+ ", status=" + status + "]";
	}
	
	
	

	
}
