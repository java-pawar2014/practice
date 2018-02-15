package com.springcore.colmerge.bean;

import java.util.List;

/**
 * @author bpawar
 *
 */
public class Course {

	private String courseCode;
	private String courseName;
	private int courseDuration;
	private List<String> subjects;

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Course [courseCode=" + courseCode + ", courseName=" + courseName + ", courseDuration=" + courseDuration
				+ ", subjects=" + subjects + "]";
	}
}
