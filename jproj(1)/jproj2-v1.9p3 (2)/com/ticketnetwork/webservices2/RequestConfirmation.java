
package com.ticketnetwork.webservices2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RequestConfirmation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestConfirmation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ConfirmationEmailText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestConfirmation", propOrder = {
    "requestID",
    "confirmationEmailText"
})
public class RequestConfirmation {

    @XmlElement(name = "RequestID")
    protected int requestID;
    @XmlElement(name = "ConfirmationEmailText")
    protected String confirmationEmailText;

    /**
     * Gets the value of the requestID property.
     * 
     */
    public int getRequestID() {
        return requestID;
    }

    /**
     * Sets the value of the requestID property.
     * 
     */
    public void setRequestID(int value) {
        this.requestID = value;
    }

    /**
     * Gets the value of the confirmationEmailText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfirmationEmailText() {
        return confirmationEmailText;
    }

    /**
     * Sets the value of the confirmationEmailText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfirmationEmailText(String value) {
        this.confirmationEmailText = value;
    }

}
