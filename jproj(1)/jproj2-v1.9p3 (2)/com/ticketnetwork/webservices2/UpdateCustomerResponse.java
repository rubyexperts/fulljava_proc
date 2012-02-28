
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
 *         &lt;element name="UpdateCustomerResult" type="{http://webservices2.ticketnetwork.com}Customer" minOccurs="0"/>
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
    "updateCustomerResult"
})
@XmlRootElement(name = "UpdateCustomerResponse")
public class UpdateCustomerResponse {

    @XmlElement(name = "UpdateCustomerResult")
    protected Customer updateCustomerResult;

    /**
     * Gets the value of the updateCustomerResult property.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getUpdateCustomerResult() {
        return updateCustomerResult;
    }

    /**
     * Sets the value of the updateCustomerResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setUpdateCustomerResult(Customer value) {
        this.updateCustomerResult = value;
    }

}
