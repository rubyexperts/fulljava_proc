
package com.ticketnetwork.webservices2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetCreditCardResult" type="{http://webservices2.ticketnetwork.com}ArrayOfCreditCard" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getCreditCardResult"
})
@XmlRootElement(name = "GetCreditCardResponse")
public class GetCreditCardResponse {

    @XmlElement(name = "GetCreditCardResult")
    protected ArrayOfCreditCard getCreditCardResult;

    /**
     * Gets the value of the getCreditCardResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCreditCard }
     *     
     */
    public ArrayOfCreditCard getGetCreditCardResult() {
        return getCreditCardResult;
    }

    /**
     * Sets the value of the getCreditCardResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCreditCard }
     *     
     */
    public void setGetCreditCardResult(ArrayOfCreditCard value) {
        this.getCreditCardResult = value;
    }

}
