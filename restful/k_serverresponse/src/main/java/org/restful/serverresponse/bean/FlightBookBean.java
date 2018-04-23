package org.restful.serverresponse.bean;

import java.io.Serializable;
import java.util.Date;

import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.restful.serverresponse.adapter.JsonXmlDateTimeAdapter;

@XmlRootElement(name = "flight-booking")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class FlightBookBean implements Serializable {

	private static final long serialVersionUID = -736421534227744648L;

	@XmlElement(name = "flight-code", required = true)
	private String flightCode;

	@XmlElement(name = "source", required = true)
	private String source;

	@XmlElement(name = "destn", required = true)
	private String destination;

	@JsonbTypeAdapter(value = JsonXmlDateTimeAdapter.class)
	@XmlJavaTypeAdapter(value = JsonXmlDateTimeAdapter.class)
	@XmlElement(name = "flight-date", required = true)
	private Date flightDate;

	@XmlElement(name = "passengers", required = true)
	private int passengerCount;

	@XmlElement(name = "total-amount", required = false)
	private double fareAmount;

	@XmlElement(name = "booking-status", required = false)
	private boolean booked;

	public String getFlightCode() {
		return this.flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getFlightDate() {
		return this.flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

	public int getPassengerCount() {
		return this.passengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}

	public double getFareAmount() {
		return this.fareAmount;
	}

	public void setFareAmount(double fareAmount) {
		this.fareAmount = fareAmount;
	}

	public boolean isBooked() {
		return this.booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.booked ? 1231 : 1237);
		result = prime * result + ((this.destination == null) ? 0 : this.destination.hashCode());
		long temp;
		temp = Double.doubleToLongBits(this.fareAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((this.flightCode == null) ? 0 : this.flightCode.hashCode());
		result = prime * result + ((this.flightDate == null) ? 0 : this.flightDate.hashCode());
		result = prime * result + this.passengerCount;
		result = prime * result + ((this.source == null) ? 0 : this.source.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightBookBean other = (FlightBookBean) obj;
		if (this.booked != other.booked)
			return false;
		if (this.destination == null) {
			if (other.destination != null)
				return false;
		} else if (!this.destination.equals(other.destination))
			return false;
		if (Double.doubleToLongBits(this.fareAmount) != Double.doubleToLongBits(other.fareAmount))
			return false;
		if (this.flightCode == null) {
			if (other.flightCode != null)
				return false;
		} else if (!this.flightCode.equals(other.flightCode))
			return false;
		if (this.flightDate == null) {
			if (other.flightDate != null)
				return false;
		} else if (!this.flightDate.equals(other.flightDate))
			return false;
		if (this.passengerCount != other.passengerCount)
			return false;
		if (this.source == null) {
			if (other.source != null)
				return false;
		} else if (!this.source.equals(other.source))
			return false;
		return true;
	}
}
