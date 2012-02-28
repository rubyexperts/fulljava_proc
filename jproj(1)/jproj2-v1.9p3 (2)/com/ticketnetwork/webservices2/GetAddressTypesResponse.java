
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
 *         &lt;element name="GetAddressTypesResult" type="{http://webservices2.ticketnetwork.com}ArrayOfAddressType" minOccurs="0"/>
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
    "getAddressTypesResult"
})
@XmlRootElement(name = "GetAddressTypesResponse")
public class GetAddressTypesResponse {

    @XmlElement(name = "GetAddressTypesResult")
    protected ArrayOfAddressType getAddressTypesResult;

    /**
     * Gets the value of the getAddressTypesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfAddressType }
     *     
     */
    public ArrayOfAddressType getGetAddressTypesResult() {
        return getAddressTypesResult;
    }

    /**
     * Sets the value of the getAddressTypesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfAddressType }
     *     
     */
    public void setGetAddressTypesResult(ArrayOfAddressType value) {
        this.getAddressTypesResult = value;
    }

}
