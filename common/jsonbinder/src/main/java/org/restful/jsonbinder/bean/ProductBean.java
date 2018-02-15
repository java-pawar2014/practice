package org.restful.jsonbinder.bean;

import java.io.Serializable;

/**
 * @author bpawar
 *
 */
public class ProductBean implements Serializable {

	private static final long serialVersionUID = 5190589499759405276L;

	private String productName;
	private String description;
	private double weight;
	private PriceBean price;

	public ProductBean() {
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public PriceBean getPrice() {
		return price;
	}

	public void setPrice(PriceBean price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ProductBean [productName=" + productName + ", description=" + description + ", weight=" + weight
				+ ", price=" + price + "]";
	}

}
