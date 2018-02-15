package com.springcore.colinj.bean;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author bpawar
 *
 */
public class Course {

	private int courseCode;
	private String courseName;

	/**
	 * Injecting collection of subjects as list
	 */
	private List<Subject> subjects;
	private Set<Subject> subjectsSet;
	private Map<String, Subject> subjectMap;

	/**
	 * Injecting collection of subjects as map
	 * 
	 * @param subjectMap
	 */
	public Course(Map<String, Subject> subjectMap) {
		super();
		this.subjectMap = subjectMap;
	}

	/**
	 * Injecting collection of subjects as set
	 * 
	 * @param subjectsSet
	 */

	public Course(Set<Subject> subjectsSet) {
		this.subjectsSet = subjectsSet;
	}

	public Set<Subject> getSubjectsSet() {
		return subjectsSet;
	}

	public void setSubjectsSet(Set<Subject> subjectsSet) {
		this.subjectsSet = subjectsSet;
	}

	public int getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(int courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "Course [courseCode=" + courseCode + ", courseName=" + courseName + ",\nsubjects=" + subjects
				+ ", subjectsSet=" + subjectsSet + ", subjectMap=" + subjectMap + "]";
	}
}