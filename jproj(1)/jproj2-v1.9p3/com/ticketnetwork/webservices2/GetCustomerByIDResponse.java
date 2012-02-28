
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
 *         &lt;element name="GetCustomerByIDResult" type="{http://webservices2.ticketnetwork.com}Customer" minOccurs="0"/>
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
    "getCustomerByIDResult"
})
@XmlRootElement(name = "GetCustomerByIDResponse")
public class GetCustomerByIDResponse {

    @XmlElement(name = "GetCustomerByIDResult")
    protected Customer getCustomerByIDResult;

    /**
     * Gets the value of the getCustomerByIDResult property.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getGetCustomerByIDResult() {
        return getCustomerByIDResult;
    }

    /**
     * Sets the value of the getCustomerByIDResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setGetCustomerByIDResult(Customer value) {
        this.getCustomerByIDResult = value;
    }

}
