package com.agsft.droolattributes.fact;

public class TaxiRide {

	private boolean isNightSurcharge;
	private double distance;

	public TaxiRide() {
	}

	public TaxiRide(boolean isNightSurcharge, double distance) {
		super();
		this.isNightSurcharge = isNightSurcharge;
		this.distance = distance;
	}

	public boolean isNightSurcharge() {
		return isNightSurcharge;
	}

	public void setNightSurcharge(boolean isNightSurcharge) {
		this.isNightSurcharge = isNightSurcharge;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "TaxiRide [isNightSurcharge=" + isNightSurcharge + ", distance=" + distance + "]";
	}

}
