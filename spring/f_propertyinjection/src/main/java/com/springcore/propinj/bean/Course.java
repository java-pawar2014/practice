package com.springcore.propinj.bean;

import java.util.Properties;

public class Course {

	private Properties subjects;

	public Course() {
	}

	public Course(Properties subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		StringBuilder builder = null;

		builder = new StringBuilder();
		if (!subjects.keySet().isEmpty()) {
			builder.append("Faculty\t\tSubject\n");
			for (Object faculty : subjects.keySet()) {
				builder.append(faculty).append("\t\t").append(subjects.get(faculty)).append("\n");
			}
		}
		return builder.toString();
	}

	public Properties getSubjects() {
		return subjects;
	}

	public void setSubjects(Properties subjects) {
		this.subjects = subjects;
	}

}
