
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
 *         &lt;element name="CreateCustomerResult" type="{http://webservices2.ticketnetwork.com}Customer" minOccurs="0"/>
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
    "createCustomerResult"
})
@XmlRootElement(name = "CreateCustomerResponse")
public class CreateCustomerResponse {

    @XmlElement(name = "CreateCustomerResult")
    protected Customer createCustomerResult;

    /**
     * Gets the value of the createCustomerResult property.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getCreateCustomerResult() {
        return createCustomerResult;
    }

    /**
     * Sets the value of the createCustomerResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setCreateCustomerResult(Customer value) {
        this.createCustomerResult = value;
    }

}
