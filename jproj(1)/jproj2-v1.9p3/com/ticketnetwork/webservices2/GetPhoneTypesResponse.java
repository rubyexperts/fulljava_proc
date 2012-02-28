
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
 *         &lt;element name="GetPhoneTypesResult" type="{http://webservices2.ticketnetwork.com}ArrayOfPhoneType" minOccurs="0"/>
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
    "getPhoneTypesResult"
})
@XmlRootElement(name = "GetPhoneTypesResponse")
public class GetPhoneTypesResponse {

    @XmlElement(name = "GetPhoneTypesResult")
    protected ArrayOfPhoneType getPhoneTypesResult;

    /**
     * Gets the value of the getPhoneTypesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfPhoneType }
     *     
     */
    public ArrayOfPhoneType getGetPhoneTypesResult() {
        return getPhoneTypesResult;
    }

    /**
     * Sets the value of the getPhoneTypesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfPhoneType }
     *     
     */
    public void setGetPhoneTypesResult(ArrayOfPhoneType value) {
        this.getPhoneTypesResult = value;
    }

}
