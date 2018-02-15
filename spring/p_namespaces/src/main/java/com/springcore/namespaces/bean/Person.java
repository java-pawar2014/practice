package com.springcore.namespaces.bean;

public class Person {
	private String personId;
	private String personName;
	private Course course;

	public Person() {
	}

	public Person(Course course) {
		super();
		this.course = course;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", course=" + course + "]";
	}
}
