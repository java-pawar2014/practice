package org.restful.jsonbinder.bean;

import java.io.Serializable;

/**
 * @author bpawar
 *
 */
public class PriceBean implements Serializable {

	private static final long serialVersionUID = -296778924116098452L;

	private double minPrice;
	private double maxPrice;

	public PriceBean() {
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	@Override
	public String toString() {
		return "PriceBean [minPrice=" + minPrice + ", maxPrice=" + maxPrice + "]";
	}

}
