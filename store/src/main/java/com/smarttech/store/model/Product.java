package com.smarttech.store.model;

/**
 * @author bpawar
 * @since Aug 18, 2018
 */
public class Product {

	private long id;
	private String name;
	private long price;

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

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Product(long id, String name, long price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

}
