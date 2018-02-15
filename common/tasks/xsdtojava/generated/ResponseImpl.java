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
 * <p>Java class for responseImpl complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="responseImpl">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="error" type="{}apiResponseError" minOccurs="0"/>
 *         &lt;element ref="{}appendix" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseImpl", propOrder = {
    "error",
    "appendix"
})
@XmlSeeAlso({
    FlightTrackResponse.class,
    FlightStatusExtendedsResponse.class,
    FlightTracksResponse.class,
    FlightStatusesResponse.class,
    FlightStatusResponse.class,
    FlightPositionResponse.class
})
public abstract class ResponseImpl {

    protected ApiResponseError error;
    protected Appendices appendix;

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link ApiResponseError }
     *     
     */
    public ApiResponseError getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApiResponseError }
     *     
     */
    public void setError(ApiResponseError value) {
        this.error = value;
    }

    /**
     * Gets the value of the appendix property.
     * 
     * @return
     *     possible object is
     *     {@link Appendices }
     *     
     */
    public Appendices getAppendix() {
        return appendix;
    }

    /**
     * Sets the value of the appendix property.
     * 
     * @param value
     *     allowed object is
     *     {@link Appendices }
     *     
     */
    public void setAppendix(Appendices value) {
        this.appendix = value;
    }

}
