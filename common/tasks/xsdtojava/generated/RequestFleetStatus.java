//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.26 at 02:59:00 PM IST 
//


package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for requestFleetStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestFleetStatus">
 *   &lt;complexContent>
 *     &lt;extension base="{}requestBase">
 *       &lt;sequence>
 *         &lt;element name="airline" type="{}requestedAirlineV1" minOccurs="0"/>
 *         &lt;element name="airport" type="{}requestedAirportV1" minOccurs="0"/>
 *         &lt;element name="codeshares" type="{}requestedBoolean" minOccurs="0"/>
 *         &lt;element name="date" type="{}requestedDate" minOccurs="0"/>
 *         &lt;element name="hourOfDay" type="{}requestedInteger" minOccurs="0"/>
 *         &lt;element name="numHours" type="{}requestedInteger" minOccurs="0"/>
 *         &lt;element name="utc" type="{}requestedBoolean" minOccurs="0"/>
 *         &lt;element name="codeType" type="{}requestedString" minOccurs="0"/>
 *         &lt;element name="maxFlights" type="{}requestedInteger" minOccurs="0"/>
 *         &lt;element name="extendedOptions" type="{}requestedString" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestFleetStatus", propOrder = {
    "airline",
    "airport",
    "codeshares",
    "date",
    "hourOfDay",
    "numHours",
    "utc",
    "codeType",
    "maxFlights",
    "extendedOptions"
})
public class RequestFleetStatus
    extends RequestBase
{

    protected RequestedAirlineV1 airline;
    protected RequestedAirportV1 airport;
    protected RequestedBoolean codeshares;
    protected RequestedDate date;
    protected RequestedInteger hourOfDay;
    protected RequestedInteger numHours;
    protected RequestedBoolean utc;
    protected RequestedString codeType;
    protected RequestedInteger maxFlights;
    protected RequestedString extendedOptions;

    /**
     * Gets the value of the airline property.
     * 
     * @return
     *     possible object is
     *     {@link RequestedAirlineV1 }
     *     
     */
    public RequestedAirlineV1 getAirline() {
        return airline;
    }

    /**
     * Sets the value of the airline property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedAirlineV1 }
     *     
     */
    public void setAirline(RequestedAirlineV1 value) {
        this.airline = value;
    }

    /**
     * Gets the value of the airport property.
     * 
     * @return
     *     possible object is
     *     {@link RequestedAirportV1 }
     *     
     */
    public RequestedAirportV1 getAirport() {
        return airport;
    }

    /**
     * Sets the value of the airport property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedAirportV1 }
     *     
     */
    public void setAirport(RequestedAirportV1 value) {
        this.airport = value;
    }

    /**
     * Gets the value of the codeshares property.
     * 
     * @return
     *     possible object is
     *     {@link RequestedBoolean }
     *     
     */
    public RequestedBoolean getCodeshares() {
        return codeshares;
    }

    /**
     * Sets the value of the codeshares property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedBoolean }
     *     
     */
    public void setCodeshares(RequestedBoolean value) {
        this.codeshares = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link RequestedDate }
     *     
     */
    public RequestedDate getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedDate }
     *     
     */
    public void setDate(RequestedDate value) {
        this.date = value;
    }

    /**
     * Gets the value of the hourOfDay property.
     * 
     * @return
     *     possible object is
     *     {@link RequestedInteger }
     *     
     */
    public RequestedInteger getHourOfDay() {
        return hourOfDay;
    }

    /**
     * Sets the value of the hourOfDay property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedInteger }
     *     
     */
    public void setHourOfDay(RequestedInteger value) {
        this.hourOfDay = value;
    }

    /**
     * Gets the value of the numHours property.
     * 
     * @return
     *     possible object is
     *     {@link RequestedInteger }
     *     
     */
    public RequestedInteger getNumHours() {
        return numHours;
    }

    /**
     * Sets the value of the numHours property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedInteger }
     *     
     */
    public void setNumHours(RequestedInteger value) {
        this.numHours = value;
    }

    /**
     * Gets the value of the utc property.
     * 
     * @return
     *     possible object is
     *     {@link RequestedBoolean }
     *     
     */
    public RequestedBoolean getUtc() {
        return utc;
    }

    /**
     * Sets the value of the utc property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedBoolean }
     *     
     */
    public void setUtc(RequestedBoolean value) {
        this.utc = value;
    }

    /**
     * Gets the value of the codeType property.
     * 
     * @return
     *     possible object is
     *     {@link RequestedString }
     *     
     */
    public RequestedString getCodeType() {
        return codeType;
    }

    /**
     * Sets the value of the codeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedString }
     *     
     */
    public void setCodeType(RequestedString value) {
        this.codeType = value;
    }

    /**
     * Gets the value of the maxFlights property.
     * 
     * @return
     *     possible object is
     *     {@link RequestedInteger }
     *     
     */
    public RequestedInteger getMaxFlights() {
        return maxFlights;
    }

    /**
     * Sets the value of the maxFlights property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedInteger }
     *     
     */
    public void setMaxFlights(RequestedInteger value) {
        this.maxFlights = value;
    }

    /**
     * Gets the value of the extendedOptions property.
     * 
     * @return
     *     possible object is
     *     {@link RequestedString }
     *     
     */
    public RequestedString getExtendedOptions() {
        return extendedOptions;
    }

    /**
     * Sets the value of the extendedOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedString }
     *     
     */
    public void setExtendedOptions(RequestedString value) {
        this.extendedOptions = value;
    }

}
