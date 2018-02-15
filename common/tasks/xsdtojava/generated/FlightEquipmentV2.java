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
 * <p>Java class for flightEquipmentV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="flightEquipmentV2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="scheduledEquipment" type="{}equipmentV1" minOccurs="0"/>
 *         &lt;element name="scheduledEquipmentIataCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="actualEquipment" type="{}equipmentV1" minOccurs="0"/>
 *         &lt;element name="actualEquipmentIataCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tailNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flightEquipmentV2", propOrder = {
    "scheduledEquipment",
    "scheduledEquipmentIataCode",
    "actualEquipment",
    "actualEquipmentIataCode",
    "tailNumber"
})
public class FlightEquipmentV2 {

    protected EquipmentV1 scheduledEquipment;
    protected String scheduledEquipmentIataCode;
    protected EquipmentV1 actualEquipment;
    protected String actualEquipmentIataCode;
    protected String tailNumber;

    /**
     * Gets the value of the scheduledEquipment property.
     * 
     * @return
     *     possible object is
     *     {@link EquipmentV1 }
     *     
     */
    public EquipmentV1 getScheduledEquipment() {
        return scheduledEquipment;
    }

    /**
     * Sets the value of the scheduledEquipment property.
     * 
     * @param value
     *     allowed object is
     *     {@link EquipmentV1 }
     *     
     */
    public void setScheduledEquipment(EquipmentV1 value) {
        this.scheduledEquipment = value;
    }

    /**
     * Gets the value of the scheduledEquipmentIataCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScheduledEquipmentIataCode() {
        return scheduledEquipmentIataCode;
    }

    /**
     * Sets the value of the scheduledEquipmentIataCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScheduledEquipmentIataCode(String value) {
        this.scheduledEquipmentIataCode = value;
    }

    /**
     * Gets the value of the actualEquipment property.
     * 
     * @return
     *     possible object is
     *     {@link EquipmentV1 }
     *     
     */
    public EquipmentV1 getActualEquipment() {
        return actualEquipment;
    }

    /**
     * Sets the value of the actualEquipment property.
     * 
     * @param value
     *     allowed object is
     *     {@link EquipmentV1 }
     *     
     */
    public void setActualEquipment(EquipmentV1 value) {
        this.actualEquipment = value;
    }

    /**
     * Gets the value of the actualEquipmentIataCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActualEquipmentIataCode() {
        return actualEquipmentIataCode;
    }

    /**
     * Sets the value of the actualEquipmentIataCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActualEquipmentIataCode(String value) {
        this.actualEquipmentIataCode = value;
    }

    /**
     * Gets the value of the tailNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTailNumber() {
        return tailNumber;
    }

    /**
     * Sets the value of the tailNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTailNumber(String value) {
        this.tailNumber = value;
    }

}