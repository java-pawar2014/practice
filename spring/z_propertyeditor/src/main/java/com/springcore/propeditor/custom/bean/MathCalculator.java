package com.springcore.propeditor.custom.bean;

public class MathCalculator {

	private ComplexNumber complexNumber;

	public ComplexNumber getComplexNumber() {
		return complexNumber;
	}

	public void setComplexNumber(ComplexNumber complexNumber) {
		this.complexNumber = complexNumber;
	}

	public void calculate() {
		System.out.println("Calculating with complex number base : " + complexNumber.getBase() + " and Exponent : "
				+ complexNumber.getExponent());
	}

}
