//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.26 at 02:59:00 PM IST 
//


package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for flightStatusResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="flightStatusResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{}responseImpl">
 *       &lt;sequence>
 *         &lt;element ref="{}flightStatus" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flightStatusResponse", propOrder = {
    "flightStatus"
})
@XmlSeeAlso({
    ResponseFlightStatusById.class
})
public abstract class FlightStatusResponse
    extends ResponseImpl
{

    protected FlightStatusV2 flightStatus;

    /**
     * Gets the value of the flightStatus property.
     * 
     * @return
     *     possible object is
     *     {@link FlightStatusV2 }
     *     
     */
    public FlightStatusV2 getFlightStatus() {
        return flightStatus;
    }

    /**
     * Sets the value of the flightStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link FlightStatusV2 }
     *     
     */
    public void setFlightStatus(FlightStatusV2 value) {
        this.flightStatus = value;
    }

}
