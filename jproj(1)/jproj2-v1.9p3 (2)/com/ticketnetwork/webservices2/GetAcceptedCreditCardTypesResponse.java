
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
 *         &lt;element name="GetAcceptedCreditCardTypesResult" type="{http://webservices2.ticketnetwork.com}ArrayOfCreditCardType" minOccurs="0"/>
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
    "getAcceptedCreditCardTypesResult"
})
@XmlRootElement(name = "GetAcceptedCreditCardTypesResponse")
public class GetAcceptedCreditCardTypesResponse {

    @XmlElement(name = "GetAcceptedCreditCardTypesResult")
    protected ArrayOfCreditCardType getAcceptedCreditCardTypesResult;

    /**
     * Gets the value of the getAcceptedCreditCardTypesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfCreditCardType }
     *     
     */
    public ArrayOfCreditCardType getGetAcceptedCreditCardTypesResult() {
        return getAcceptedCreditCardTypesResult;
    }

    /**
     * Sets the value of the getAcceptedCreditCardTypesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfCreditCardType }
     *     
     */
    public void setGetAcceptedCreditCardTypesResult(ArrayOfCreditCardType value) {
        this.getAcceptedCreditCardTypesResult = value;
    }

}
