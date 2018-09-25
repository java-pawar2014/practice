package com.agsft.droolhiring.model;

/**
 * @author bpawar
 * @since 13-Aug-2018
 */
public class Skill {

	private long id;
	private String name;

	public Skill() {
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

	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + "]";
	}

}
