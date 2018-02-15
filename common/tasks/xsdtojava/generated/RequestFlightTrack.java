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
 * <p>Java class for requestFlightTrack complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestFlightTrack">
 *   &lt;complexContent>
 *     &lt;extension base="{}requestBase">
 *       &lt;sequence>
 *         &lt;element name="airline" type="{}requestedAirlineV1" minOccurs="0"/>
 *         &lt;element name="flight" type="{}requestedFlightNumber" minOccurs="0"/>
 *         &lt;element name="date" type="{}requestedDate" minOccurs="0"/>
 *         &lt;element name="hourOfDay" type="{}requestedInteger" minOccurs="0"/>
 *         &lt;element name="numHours" type="{}requestedInteger" minOccurs="0"/>
 *         &lt;element name="utc" type="{}requestedBoolean" minOccurs="0"/>
 *         &lt;element name="airport" type="{}requestedAirportV1" minOccurs="0"/>
 *         &lt;element name="includeFlightPlan" type="{}requestedBoolean" minOccurs="0"/>
 *         &lt;element name="maxPositions" type="{}requestedInteger" minOccurs="0"/>
 *         &lt;element name="maxPositionAgeMinutes" type="{}requestedInteger" minOccurs="0"/>
 *         &lt;element name="codeType" type="{}requestedString" minOccurs="0"/>
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
@XmlType(name = "requestFlightTrack", propOrder = {
    "airline",
    "flight",
    "date",
    "hourOfDay",
    "numHours",
    "utc",
    "airport",
    "includeFlightPlan",
    "maxPositions",
    "maxPositionAgeMinutes",
    "codeType",
    "extendedOptions"
})
public class RequestFlightTrack
    extends RequestBase
{

    protected RequestedAirlineV1 airline;
    protected RequestedFlightNumber flight;
    protected RequestedDate date;
    protected RequestedInteger hourOfDay;
    protected RequestedInteger numHours;
    protected RequestedBoolean utc;
    protected RequestedAirportV1 airport;
    protected RequestedBoolean includeFlightPlan;
    protected RequestedInteger maxPositions;
    protected RequestedInteger maxPositionAgeMinutes;
    protected RequestedString codeType;
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
     * Gets the value of the flight property.
     * 
     * @return
     *     possible object is
     *     {@link RequestedFlightNumber }
     *     
     */
    public RequestedFlightNumber getFlight() {
        return flight;
    }

    /**
     * Sets the value of the flight property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedFlightNumber }
     *     
     */
    public void setFlight(RequestedFlightNumber value) {
        this.flight = value;
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
     * Gets the value of the includeFlightPlan property.
     * 
     * @return
     *     possible object is
     *     {@link RequestedBoolean }
     *     
     */
    public RequestedBoolean getIncludeFlightPlan() {
        return includeFlightPlan;
    }

    /**
     * Sets the value of the includeFlightPlan property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedBoolean }
     *     
     */
    public void setIncludeFlightPlan(RequestedBoolean value) {
        this.includeFlightPlan = value;
    }

    /**
     * Gets the value of the maxPositions property.
     * 
     * @return
     *     possible object is
     *     {@link RequestedInteger }
     *     
     */
    public RequestedInteger getMaxPositions() {
        return maxPositions;
    }

    /**
     * Sets the value of the maxPositions property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedInteger }
     *     
     */
    public void setMaxPositions(RequestedInteger value) {
        this.maxPositions = value;
    }

    /**
     * Gets the value of the maxPositionAgeMinutes property.
     * 
     * @return
     *     possible object is
     *     {@link RequestedInteger }
     *     
     */
    public RequestedInteger getMaxPositionAgeMinutes() {
        return maxPositionAgeMinutes;
    }

    /**
     * Sets the value of the maxPositionAgeMinutes property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedInteger }
     *     
     */
    public void setMaxPositionAgeMinutes(RequestedInteger value) {
        this.maxPositionAgeMinutes = value;
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