//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.26 at 02:59:00 PM IST 
//

package com.flightapi.bind.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for responseFlightTrack complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="responseFlightTrack">
 *   &lt;complexContent>
 *     &lt;extension base="{}flightTracksResponse">
 *       &lt;sequence>
 *         &lt;element ref="{}request" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseFlightTrack", propOrder = { "request" })
public class ResponseFlightTrack extends FlightTracksResponse {

	@XmlElement(nillable = true)
	protected Object request;

	/**
	 * Gets the value of the request property.
	 * 
	 * @return possible object is {@link Object }
	 * 
	 */
	public Object getRequest() {
		return request;
	}

	/**
	 * Sets the value of the request property.
	 * 
	 * @param value
	 *            allowed object is {@link Object }
	 * 
	 */
	public void setRequest(Object value) {
		this.request = value;
	}

}
