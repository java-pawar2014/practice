//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.26 at 02:59:00 PM IST 
//


package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for flightStatusUpdatedDateV2 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="flightStatusUpdatedDateV2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="field" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="originalDateLocal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newDateLocal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="originalDateUtc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newDateUtc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flightStatusUpdatedDateV2", propOrder = {
    "field",
    "originalDateLocal",
    "newDateLocal",
    "originalDateUtc",
    "newDateUtc"
})
public class FlightStatusUpdatedDateV2 {

    @XmlElement(required = true)
    protected String field;
    protected String originalDateLocal;
    protected String newDateLocal;
    protected String originalDateUtc;
    protected String newDateUtc;

    /**
     * Gets the value of the field property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getField() {
        return field;
    }

    /**
     * Sets the value of the field property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setField(String value) {
        this.field = value;
    }

    /**
     * Gets the value of the originalDateLocal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalDateLocal() {
        return originalDateLocal;
    }

    /**
     * Sets the value of the originalDateLocal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalDateLocal(String value) {
        this.originalDateLocal = value;
    }

    /**
     * Gets the value of the newDateLocal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewDateLocal() {
        return newDateLocal;
    }

    /**
     * Sets the value of the newDateLocal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewDateLocal(String value) {
        this.newDateLocal = value;
    }

    /**
     * Gets the value of the originalDateUtc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalDateUtc() {
        return originalDateUtc;
    }

    /**
     * Sets the value of the originalDateUtc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalDateUtc(String value) {
        this.originalDateUtc = value;
    }

    /**
     * Gets the value of the newDateUtc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewDateUtc() {
        return newDateUtc;
    }

    /**
     * Sets the value of the newDateUtc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewDateUtc(String value) {
        this.newDateUtc = value;
    }

}