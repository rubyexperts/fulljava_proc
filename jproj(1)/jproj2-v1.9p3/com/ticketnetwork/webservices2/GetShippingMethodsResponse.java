
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
 *         &lt;element name="GetShippingMethodsResult" type="{http://webservices2.ticketnetwork.com}ArrayOfShippingMethod" minOccurs="0"/>
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
    "getShippingMethodsResult"
})
@XmlRootElement(name = "GetShippingMethodsResponse")
public class GetShippingMethodsResponse {

    @XmlElement(name = "GetShippingMethodsResult")
    protected ArrayOfShippingMethod getShippingMethodsResult;

    /**
     * Gets the value of the getShippingMethodsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfShippingMethod }
     *     
     */
    public ArrayOfShippingMethod getGetShippingMethodsResult() {
        return getShippingMethodsResult;
    }

    /**
     * Sets the value of the getShippingMethodsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfShippingMethod }
     *     
     */
    public void setGetShippingMethodsResult(ArrayOfShippingMethod value) {
        this.getShippingMethodsResult = value;
    }

}
