
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
 *         &lt;element name="UpdateCreditCardResult" type="{http://webservices2.ticketnetwork.com}CreditCard" minOccurs="0"/>
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
    "updateCreditCardResult"
})
@XmlRootElement(name = "UpdateCreditCardResponse")
public class UpdateCreditCardResponse {

    @XmlElement(name = "UpdateCreditCardResult")
    protected CreditCard updateCreditCardResult;

    /**
     * Gets the value of the updateCreditCardResult property.
     * 
     * @return
     *     possible object is
     *     {@link CreditCard }
     *     
     */
    public CreditCard getUpdateCreditCardResult() {
        return updateCreditCardResult;
    }

    /**
     * Sets the value of the updateCreditCardResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditCard }
     *     
     */
    public void setUpdateCreditCardResult(CreditCard value) {
        this.updateCreditCardResult = value;
    }

}
