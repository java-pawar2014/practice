package com.agsft.droolhiring.dto;

import java.util.Arrays;

/**
 * @author bpawar
 * @since 13-Aug-2018
 */
public class CandidateDTO {

	private String name;
	private String contact;
	private String[] skills;

	private boolean javaSkill;
	private boolean aptitude;
	private boolean technical1;
	private boolean machine;
	private boolean technical2;
	private boolean hr;
	private boolean selected;

	public CandidateDTO(String name, String contact, String[] skills) {
		this.name = name;
		this.contact = contact;
		this.skills = skills;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	public boolean isJavaSkill() {
		return javaSkill;
	}

	public void setJavaSkill(boolean javaSkill) {
		this.javaSkill = javaSkill;
	}

	public boolean isAptitude() {
		return aptitude;
	}

	public void setAptitude(boolean aptitude) {
		this.aptitude = aptitude;
	}

	public boolean isTechnical1() {
		return technical1;
	}

	public void setTechnical1(boolean technical1) {
		this.technical1 = technical1;
	}

	public boolean isMachine() {
		return machine;
	}

	public void setMachine(boolean machine) {
		this.machine = machine;
	}

	public boolean isTechnical2() {
		return technical2;
	}

	public void setTechnical2(boolean technical2) {
		this.technical2 = technical2;
	}

	public boolean isHr() {
		return hr;
	}

	public void setHr(boolean hr) {
		this.hr = hr;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return "CandidateDTO [name=" + name + ", contact=" + contact + ", skills=" + Arrays.toString(skills)
				+ ", javaSkill=" + javaSkill + ", aptitude=" + aptitude + ", technical1=" + technical1 + ", machine="
				+ machine + ", technical2=" + technical2 + ", hr=" + hr + ", selected=" + selected + "]";
	}

}
