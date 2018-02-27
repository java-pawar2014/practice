package org.restful.serverresponse.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "flight-status")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class FlightStatusBean implements Serializable {

	private static final long serialVersionUID = 4930876843160246931L;

	@XmlElement(name = "flight-id", required = true)
	private long flightId;

	@XmlElement(name = "flying-id", required = true)
	private String flyingId;

	@XmlElement(name = "flight-name", required = true)
	private String flightName;

	@XmlElement(name = "source", required = true)
	private String source;

	@XmlElement(name = "destination", required = true)
	private String destination;

	public FlightStatusBean() {

	}

	public long getFlightId() {
		return this.flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public String getFlyingId() {
		return this.flyingId;
	}

	public void setFlyingId(String flyingId) {
		this.flyingId = flyingId;
	}

	public String getFlightName() {
		return this.flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.destination == null) ? 0 : this.destination.hashCode());
		result = prime * result + (int) (this.flightId ^ (this.flightId >>> 32));
		result = prime * result + ((this.flightName == null) ? 0 : this.flightName.hashCode());
		result = prime * result + ((this.flyingId == null) ? 0 : this.flyingId.hashCode());
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
		FlightStatusBean other = (FlightStatusBean) obj;
		if (this.destination == null) {
			if (other.destination != null)
				return false;
		} else if (!this.destination.equals(other.destination))
			return false;
		if (this.flightId != other.flightId)
			return false;
		if (this.flightName == null) {
			if (other.flightName != null)
				return false;
		} else if (!this.flightName.equals(other.flightName))
			return false;
		if (this.flyingId == null) {
			if (other.flyingId != null)
				return false;
		} else if (!this.flyingId.equals(other.flyingId))
			return false;
		if (this.source == null) {
			if (other.source != null)
				return false;
		} else if (!this.source.equals(other.source))
			return false;
		return true;
	}

}
