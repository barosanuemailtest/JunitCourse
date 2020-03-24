package com.barosanu.emplapp.model;

public class User {

	private int age;
	private String name;
	private WorkingPossition workingPossition;

	public User(int age, String name, WorkingPossition workingPossition) {
		this.age = age;
		this.name = name;
		this.workingPossition = workingPossition;
	}
	
	public User() {};

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkingPossition getWorkingPossition() {
		return workingPossition;
	}

	public void setWorkingPossition(WorkingPossition workingPossition) {
		this.workingPossition = workingPossition;
	}

}
