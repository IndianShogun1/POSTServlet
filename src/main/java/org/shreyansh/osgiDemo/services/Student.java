package org.shreyansh.osgiDemo.services;

public class Student {
	
	int id;
	String name;
	int marksObtained;
	int age;
	
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
	public int getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Student(int id, String name, int marksObtained, int age) {
		super();
		this.id = id;
		this.name = name;
		this.marksObtained = marksObtained;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marksObtained=" + marksObtained + ", age=" + age + "]";
	}
	
	

}
