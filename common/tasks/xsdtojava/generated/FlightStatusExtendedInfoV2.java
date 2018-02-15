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
 * <p>Java class for flightStatusExtendedInfoV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="flightStatusExtendedInfoV2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lastPosition" type="{}positionV2" minOccurs="0"/>
 *         &lt;element name="distanceRemaining" type="{}flightDistanceV2" minOccurs="0"/>
 *         &lt;element name="distanceTraveled" type="{}flightDistanceV2" minOccurs="0"/>
 *         &lt;element name="flightNotes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flightStatusExtendedInfoV2", propOrder = {
    "lastPosition",
    "distanceRemaining",
    "distanceTraveled",
    "flightNotes"
})
public class FlightStatusExtendedInfoV2 {

    protected PositionV2 lastPosition;
    protected FlightDistanceV2 distanceRemaining;
    protected FlightDistanceV2 distanceTraveled;
    protected String flightNotes;

    /**
     * Gets the value of the lastPosition property.
     * 
     * @return
     *     possible object is
     *     {@link PositionV2 }
     *     
     */
    public PositionV2 getLastPosition() {
        return lastPosition;
    }

    /**
     * Sets the value of the lastPosition property.
     * 
     * @param value
     *     allowed object is
     *     {@link PositionV2 }
     *     
     */
    public void setLastPosition(PositionV2 value) {
        this.lastPosition = value;
    }

    /**
     * Gets the value of the distanceRemaining property.
     * 
     * @return
     *     possible object is
     *     {@link FlightDistanceV2 }
     *     
     */
    public FlightDistanceV2 getDistanceRemaining() {
        return distanceRemaining;
    }

    /**
     * Sets the value of the distanceRemaining property.
     * 
     * @param value
     *     allowed object is
     *     {@link FlightDistanceV2 }
     *     
     */
    public void setDistanceRemaining(FlightDistanceV2 value) {
        this.distanceRemaining = value;
    }

    /**
     * Gets the value of the distanceTraveled property.
     * 
     * @return
     *     possible object is
     *     {@link FlightDistanceV2 }
     *     
     */
    public FlightDistanceV2 getDistanceTraveled() {
        return distanceTraveled;
    }

    /**
     * Sets the value of the distanceTraveled property.
     * 
     * @param value
     *     allowed object is
     *     {@link FlightDistanceV2 }
     *     
     */
    public void setDistanceTraveled(FlightDistanceV2 value) {
        this.distanceTraveled = value;
    }

    /**
     * Gets the value of the flightNotes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlightNotes() {
        return flightNotes;
    }

    /**
     * Sets the value of the flightNotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlightNotes(String value) {
        this.flightNotes = value;
    }

}
