
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
 *         &lt;element name="GetReferralTypesResult" type="{http://webservices2.ticketnetwork.com}ArrayOfReferralType" minOccurs="0"/>
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
    "getReferralTypesResult"
})
@XmlRootElement(name = "GetReferralTypesResponse")
public class GetReferralTypesResponse {

    @XmlElement(name = "GetReferralTypesResult")
    protected ArrayOfReferralType getReferralTypesResult;

    /**
     * Gets the value of the getReferralTypesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfReferralType }
     *     
     */
    public ArrayOfReferralType getGetReferralTypesResult() {
        return getReferralTypesResult;
    }

    /**
     * Sets the value of the getReferralTypesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfReferralType }
     *     
     */
    public void setGetReferralTypesResult(ArrayOfReferralType value) {
        this.getReferralTypesResult = value;
    }

}
