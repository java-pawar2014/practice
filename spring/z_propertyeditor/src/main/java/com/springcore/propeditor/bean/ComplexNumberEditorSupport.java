package com.springcore.propeditor.bean;

import java.beans.PropertyEditorSupport;

import com.springcore.propeditor.custom.bean.ComplexNumber;

public class ComplexNumberEditorSupport extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		int base = 0;
		int exponent = 0;
		String[] stringSplits = null;

		stringSplits = text.trim().split(",");
		base = Integer.parseInt(stringSplits[0].trim());
		exponent = Integer.parseInt(stringSplits[1].trim());
		ComplexNumber complexNumber = new ComplexNumber(exponent, base);
		setValue(complexNumber);
	}
}
