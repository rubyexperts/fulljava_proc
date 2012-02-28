
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
 *         &lt;element name="GetRequestStatusResult" type="{http://webservices2.ticketnetwork.com}RequestStatus" minOccurs="0"/>
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
    "getRequestStatusResult"
})
@XmlRootElement(name = "GetRequestStatusResponse")
public class GetRequestStatusResponse {

    @XmlElement(name = "GetRequestStatusResult")
    protected RequestStatus getRequestStatusResult;

    /**
     * Gets the value of the getRequestStatusResult property.
     * 
     * @return
     *     possible object is
     *     {@link RequestStatus }
     *     
     */
    public RequestStatus getGetRequestStatusResult() {
        return getRequestStatusResult;
    }

    /**
     * Sets the value of the getRequestStatusResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestStatus }
     *     
     */
    public void setGetRequestStatusResult(RequestStatus value) {
        this.getRequestStatusResult = value;
    }

}
