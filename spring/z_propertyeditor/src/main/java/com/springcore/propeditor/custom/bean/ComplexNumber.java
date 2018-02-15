package com.springcore.propeditor.custom.bean;

public class ComplexNumber {

	private int exponent;
	private int base;

	public ComplexNumber() {
		// TODO Auto-generated constructor stub
	}

	public ComplexNumber(int exponent, int base) {
		this.exponent = exponent;
		this.base = base;
	}

	public int getExponent() {
		return exponent;
	}

	public void setExponent(int exponent) {
		this.exponent = exponent;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	@Override
	public String toString() {
		return "ComplexNumber [exponent=" + exponent + ", base=" + base + "]";
	}
}