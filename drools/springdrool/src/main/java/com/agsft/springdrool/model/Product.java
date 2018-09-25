/**
 * 
 */
package com.agsft.springdrool.model;

/**
 * @author bpawar
 * @since 13-Aug-2018
 */
public class Product {

	private String name;
	private String type;
	private double discount;

	public Product() {
	}

	public Product(String name, String type, double discount) {
		super();
		this.name = name;
		this.type = type;
		this.discount = discount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", type=" + type + ", discount=" + discount + "]";
	}

}
