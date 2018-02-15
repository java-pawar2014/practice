package org.restful.contenthandler.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author bpawar
 *
 */
@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class CustomerAddressBean implements Serializable {

	private static final long serialVersionUID = -4536008621271890138L;

	@XmlElement
	private String street;

	@XmlElement
	private String city;

	@XmlElement
	private String state;

	@XmlElement
	private String zip;

	public CustomerAddressBean() {
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "CustomerAddressBean [street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + "]";
	}
}
