/**
 * 
 */
package com.agsft.droolattributes.fact;

/**
 * @author bpawar
 * @since 14-Aug-2018
 */
public class Fare {

	private double nightSurcharge;
	private double rideFare;

	public Fare() {
	}

	public Fare(double nightSurcharge, double rideFare) {
		super();
		this.nightSurcharge = nightSurcharge;
		this.rideFare = rideFare;
	}

	public double getNightSurcharge() {
		return nightSurcharge;
	}

	public void setNightSurcharge(double nightSurcharge) {
		this.nightSurcharge = nightSurcharge;
	}

	public double getRideFare() {
		return rideFare;
	}

	public void setRideFare(double rideFare) {
		this.rideFare = rideFare;
	}

	@Override
	public String toString() {
		return "Fare [nightSurcharge=" + nightSurcharge + ", rideFare=" + rideFare + "]";
	}

}
