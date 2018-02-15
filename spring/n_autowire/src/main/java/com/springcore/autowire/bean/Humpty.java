package com.springcore.autowire.bean;

public class Humpty {

	private Dumpty dumpty;

	public Humpty() {
	}

	public Humpty(Dumpty dumpty) {
		this.dumpty = dumpty;
	}

	public Dumpty getDumpty() {
		return dumpty;
	}

	public void setDumpty(Dumpty dumpty) {
		System.out.println("Setter injection of Dumpty");
		this.dumpty = dumpty;
	}

	@Override
	public String toString() {
		return "I am working with Dumpty: " + getDumpty().getName();
	}
}
