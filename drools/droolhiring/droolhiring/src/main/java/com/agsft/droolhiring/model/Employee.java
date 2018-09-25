/**
 * 
 */
package com.agsft.droolhiring.model;

import java.util.List;

/**
 * @author bpawar
 * @since 13-Aug-2018
 */
public class Employee {

	private long id;
	private String name;
	private List<Skill> skills;

	public Employee() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", skills=" + skills + "]";
	}

}
