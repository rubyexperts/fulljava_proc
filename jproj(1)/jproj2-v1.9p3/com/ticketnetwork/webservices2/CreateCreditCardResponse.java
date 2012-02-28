
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
 *         &lt;element name="CreateCreditCardResult" type="{http://webservices2.ticketnetwork.com}CreditCard" minOccurs="0"/>
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
    "createCreditCardResult"
})
@XmlRootElement(name = "CreateCreditCardResponse")
public class CreateCreditCardResponse {

    @XmlElement(name = "CreateCreditCardResult")
    protected CreditCard createCreditCardResult;

    /**
     * Gets the value of the createCreditCardResult property.
     * 
     * @return
     *     possible object is
     *     {@link CreditCard }
     *     
     */
    public CreditCard getCreateCreditCardResult() {
        return createCreditCardResult;
    }

    /**
     * Sets the value of the createCreditCardResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditCard }
     *     
     */
    public void setCreateCreditCardResult(CreditCard value) {
        this.createCreditCardResult = value;
    }

}
